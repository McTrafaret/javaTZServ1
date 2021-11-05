package com.udalny.documents.packet;

import com.google.gson.Gson;
import com.udalny.documents.SummaryDocument;
import com.udalny.documents.file.FileType;
import com.udalny.documents.paydocs.PayDocs;
import com.udalny.documents.report.Doc;
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

    @Autowired
    private DocConverter docConverter;

    private static Logger logger = LoggerFactory.getLogger(ReportPayDocsPacketHandler.class);

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

        if(!report.getReport_type_flag().equals("Итоговая")) {
            return null;
        }

        Map<String, Doc> uuidMap = new HashMap<>();

        for (Doc doc : report.getDocs()) {
            uuidMap.put(doc.getDocGUID(), doc);
        }

        for (com.udalny.documents.paydocs.Doc doc: payDocs.getDocs()) {
            if(uuidMap.containsKey(doc.getGUID())) {
                res.add(new SummaryDocument(doc, uuidMap.get(doc.getGUID())));
            }
        }

        return new Gson().toJson(res);
    }

}
