package com.udalny.xml;

import com.udalny.exceptions.ParseException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public abstract class DocConverter {

    protected List<XMLParser<?>> parsers;

    private Document createDocument(InputStream in)
            throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.parse(in);
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
