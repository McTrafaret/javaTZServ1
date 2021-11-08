package com.udalny.documents.packet.handler;

import com.google.gson.Gson;
import com.udalny.documents.SummaryDocument;
import com.udalny.documents.file.FileType;
import com.udalny.documents.packet.Packet;
import com.udalny.documents.paydocs.PayDoc;
import com.udalny.documents.paydocs.PayDocs;
import com.udalny.documents.report.ReportDoc;
import com.udalny.documents.report.Report;
import com.udalny.exceptions.ParseException;
import com.udalny.xml.DocConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class ReportPayDocsPacketHandler implements PacketHandler {

    private static Logger logger = LoggerFactory.getLogger(ReportPayDocsPacketHandler.class);

    @Autowired
    private DocConverter docConverter;

    @Override
    public boolean probe(Packet packet) {
        return packet.getMainDocument().getType() == FileType.REPORT && !packet.getSecondaryDocuments().isEmpty();
    }

    @Override
    public String handle(Packet packet) {

        Report report;
        PayDocs payDocs;
        try {
            report = docConverter.parse(packet.getMainDocument().getContents());
            payDocs = docConverter.parse(packet.getSecondaryDocuments().get(0).getContents());
        } catch (ParseException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }

        List<SummaryDocument> res = new LinkedList<>();

        if(!report.getReportTypeFlag().equals("Итоговая")) {
            return null;
        }

        Map<String, ReportDoc> uuidMap = new HashMap<>();

        for (ReportDoc doc : report.getDocs()) {
            uuidMap.put(doc.getDocGUID(), doc);
        }

        for (PayDoc doc: payDocs.getDocs()) {
            if(uuidMap.containsKey(doc.getGuid())) {
                res.add(new SummaryDocument(doc, uuidMap.get(doc.getGuid())));
            }
        }

        return new Gson().toJson(res);
    }

}
