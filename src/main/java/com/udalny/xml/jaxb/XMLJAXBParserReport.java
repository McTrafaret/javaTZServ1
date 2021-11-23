package com.udalny.xml.jaxb;

import com.udalny.documents.report.Report;
import com.udalny.exceptions.ParseException;
import com.udalny.xml.Parser;
import com.udalny.xml.StringToDocumentConverter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

@Service
@Profile("JAXBParser")
public class XMLJAXBParserReport
        implements Parser<Report> {

    static final String REPORT_TAG = "SKP_REPORT_KS";
    static Logger logger = LoggerFactory.getLogger(XMLJAXBParserReport.class);


    @Override
    public Report parse(String docString)
            throws ParseException {
        try {
            logger.info(docString);
            Document doc = StringToDocumentConverter.convert(docString);
            JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Report) unmarshaller.unmarshal(doc.getDocumentElement());
        } catch (Exception ex) {
            logger.error("Failed to parse", ex);
            throw new ParseException(ex);
        }
    }

    @Override
    public boolean applied(String docString) {
        try {
            Document doc = StringToDocumentConverter.convert(docString);
            return doc.getDocumentElement().getTagName().equals(REPORT_TAG);
        } catch (Exception ex) {
            return false;
        }
    }
}