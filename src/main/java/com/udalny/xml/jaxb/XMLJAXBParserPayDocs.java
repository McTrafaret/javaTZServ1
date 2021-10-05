package com.udalny.xml.jaxb;

import com.udalny.documents.paydocs.PayDocs;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

public class XMLJAXBParserPayDocs
        implements XMLParser<PayDocs> {

    static final String PAYDOCS_TAG = "Inf_Pay_Doc";
    static Logger logger = Logger.getLogger(XMLJAXBParserPayDocs.class);

    public XMLJAXBParserPayDocs() {
        /* needed in DocConverter */
    }

    @Override
    public PayDocs parse(Document doc)
    throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(PayDocs.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return (PayDocs) unmarshaller.unmarshal(doc.getDocumentElement());
    }

    @Override
    public boolean applied(Document doc) {
        return doc.getDocumentElement().getTagName().equals(PAYDOCS_TAG);
    }
}
