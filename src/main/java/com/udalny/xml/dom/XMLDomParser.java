package com.udalny.xml.dom;

import com.udalny.util.ObjectMapper;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public abstract class XMLDomParser {

    protected Logger logger;
    protected Document doc;

    protected Document createDocument(InputStream in) {
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

    protected XMLDomParser(String filename) {
        InputStream in;
        try {
            in = new FileInputStream(filename);
        } catch (FileNotFoundException ex) {
            logger.error(ex);
            return;
        }
        doc = createDocument(in);
        logger = Logger.getLogger(this.getClass());
    }

    protected XMLDomParser(InputStream in) {
        doc = createDocument(in);
        logger = Logger.getLogger(this.getClass());
    }

    protected boolean hasChildElements(Element el) {
        NodeList children = el.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE)
                return true;
        }

        return false;
    }

    protected String getTextValue(Element el) {
        NodeList children = el.getChildNodes();
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.TEXT_NODE)
                value.append(children.item(i).getNodeValue());
        }
        return value.toString();
    }

    protected void unknownFieldMessage(String field) {
        String fmt = "Found unknown field %s while parsing the file, it won't be added to the object";
        logger.info(String.format(fmt, field));
    }

    protected <T> void checkFieldAndSet(T obj, Element el) {
        if (!hasChildElements(el)) {
            try {
                String val = getTextValue(el);
                if(val.isEmpty()) {
                    val = el.getAttribute("value");
                }
                ObjectMapper.mapStringValueToField(obj, el.getTagName(), val);
            } catch (NoSuchFieldException ex) {
                unknownFieldMessage(el.getTagName());
            }
        } else {
            unknownFieldMessage(el.getTagName());
        }
    }

    protected <T> void parseObject(T obj, Element el) {

        NodeList children = el.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                checkFieldAndSet(obj, (Element) children.item(i));
            }
        }
    }

}
