package com.udalny.xml.jaxb;

import com.udalny.exceptions.ParseException;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public final class DocConverter {

    private static Logger logger = Logger.getLogger(DocConverter.class);
    private static final DocConverter instance = new DocConverter();
    private Set<XMLParser<?>> parsers = new HashSet<>();

    private Document createDocument(InputStream in)
    throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.parse(in);
    }

    private DocConverter() {
        parsers.add(new XMLJAXBParserPayDocs());
        parsers.add(new XMLJAXBParserReport());
    }

    public static DocConverter getInstance() {
        return instance;
    }

    public <T> T parse(InputStream in)
    throws ParseException {
        try {
            Document doc = createDocument(in);
            for (XMLParser<?> parser : parsers) {
                if (parser.applied(doc)) {
                    return (T) parser.parse(doc);
                }
            }
        } catch (Exception ex) {
            throw new ParseException(ex);
        }
        throw new ParseException("The file is not applicable to any of the parsers.");
    }
}
