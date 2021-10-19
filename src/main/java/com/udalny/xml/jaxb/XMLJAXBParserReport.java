package com.udalny.xml.jaxb;

import com.udalny.documents.report.Report;
import com.udalny.exceptions.ParseException;
import com.udalny.xml.XMLParser;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

public class XMLJAXBParserReport
        implements XMLParser<Report> {

    static final String REPORT_TAG = "SKP_REPORT_KS";
    static Logger logger = LoggerFactory.getLogger(XMLJAXBParserReport.class);

    public XMLJAXBParserReport() {
        /* needed in DocConverter */
    }

    @Override
    public Report parse(Document doc)
            throws ParseException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (Report) unmarshaller.unmarshal(doc.getDocumentElement());
        } catch(JAXBException ex) {
            throw new ParseException(ex);
        }
    }

    @Override
    public boolean applied(Document doc) {
        return doc.getDocumentElement().getTagName().equals(REPORT_TAG);
    }
}
