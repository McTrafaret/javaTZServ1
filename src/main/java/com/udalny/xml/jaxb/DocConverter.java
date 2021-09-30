package com.udalny.xml.jaxb;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public final class DocConverter {

    private static Logger logger = Logger.getLogger(DocConverter.class);
    private static final DocConverter instance = new DocConverter();
    private Set<XMLParser<?>> parsers = new HashSet<>();

    private Document createDocument(InputStream in) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document ret;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            logger.error(ex);
            return null;
        }

        try {
            ret = builder.parse(in);
        } catch (Exception ex) {
            logger.error(ex);
            return null;
        }

        return ret;
    }

    private DocConverter() {
        parsers.add(new XMLJAXBParserPayDocs());
        parsers.add(new XMLJAXBParserReport());
    }

    public static DocConverter getInstance() {
        return instance;
    }

    public <T> T parse(InputStream in) {
        Document doc = createDocument(in);
        for(XMLParser<?> parser : parsers) {
            if(parser.applied(doc)) {
                return (T) parser.parse(doc);
            }
        }
        return null;
    }
}
