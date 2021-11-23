package com.udalny.xml;

import com.udalny.documents.PTDocument;
import com.udalny.exceptions.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
public class PTParser
        implements Parser<List<PTDocument>> {

    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd.MM.yyyy");
    private static final Logger logger = LoggerFactory.getLogger(PTParser.class);

    @Override
    public List<PTDocument> parse(String doc) throws ParseException {
        List<PTDocument> documents = new LinkedList<>();

        for (String line : doc.split("\n")) {
            if (line.startsWith("PT")) {
                documents.add(parsePT(line));
            }
        }
        return documents;
    }

    @Override
    public boolean applied(String doc) {
        for (String line : doc.split("\n")) {
            if (line.startsWith("PT")) {
                return true;
            }
        }
        return false;
    }

    private PTDocument parsePT(String line) {

        PTDocument document = new PTDocument();
        String[] data = line.split("\\|");
        document.setGuidReceived(data[1]);
        document.setNumReceived(data[2]);
        try {
            document.setDateReceived(dateFormatter.parse(data[3]));
        } catch (java.text.ParseException ex) {
            logger.error("Couldn't parse date", ex);
        }
        document.setAmountSend(new BigDecimal(data[4]));
        document.setSenderOrganizationName(data[5]);
        document.setGuidSend(data[8]);
        document.setTypeSend(data[9]);
        document.setTypeNameSend(data[10]);
        document.setNumSend(data[11]);
        try {
            document.setDateSend(dateFormatter.parse(data[12]));
        } catch (java.text.ParseException ex) {
            logger.error("Couldn't parse date", ex);
        }
        document.setReceiverOrganizationName(data[14]);
        document.setRejectionReason(data[20]);

        return document;
    }
}
