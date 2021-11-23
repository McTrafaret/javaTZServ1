package com.udalny.xml.jaxb;

import com.udalny.documents.paydocs.PayDocs;
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
public class XMLJAXBParserPayDocs
        implements Parser<PayDocs> {

    static final String PAYDOCS_TAG = "Inf_Pay_Doc";
    static Logger logger = LoggerFactory.getLogger(XMLJAXBParserPayDocs.class);

    @Override
    public PayDocs parse(String docString)
            throws ParseException {
        try {
            Document doc = StringToDocumentConverter.convert(docString);
            JAXBContext jaxbContext = JAXBContext.newInstance(PayDocs.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return (PayDocs) unmarshaller.unmarshal(doc.getDocumentElement());
        } catch (Exception ex) {
            logger.error("Failed to parse", ex);
            throw new ParseException(ex);
        }
    }

    @Override
    public boolean applied(String docString) {
        try {
            Document doc = StringToDocumentConverter.convert(docString);
            return doc.getDocumentElement().getTagName().equals(PAYDOCS_TAG);
        } catch (Exception ex) {
            return false;
        }
    }
}
