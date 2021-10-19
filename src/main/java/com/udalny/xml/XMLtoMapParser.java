package com.udalny.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class XMLtoMapParser {
    private InputStream in;
    static Logger logger = LoggerFactory.getLogger(XMLtoMapParser.class);

    private boolean hasChildElements(Element el) {
        NodeList children = el.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE)
                return true;
        }

        return false;
    }

    private String getTextValue(Element el) {
        NodeList children = el.getChildNodes();
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.TEXT_NODE)
                value.append(children.item(i).getNodeValue());
        }
        return value.toString();
    }

    private void addTagToHashMap(HashMap<String, Object> map, String tagName, Object value) {
        if (map.containsKey(tagName)) {
            Object mappedTo = map.get(tagName);
            LinkedList<Object> list;
            if (mappedTo instanceof LinkedList<?>) {
                list = (LinkedList<Object>) mappedTo;
            } else {
                list = new LinkedList<>();
                map.put(tagName, list);
                list.add(map.get(tagName));
            }
            list.add(value);
        } else {
            map.put(tagName, value);
        }
    }

    private void parseElement(HashMap<String, Object> map, Element el) {
        if (!hasChildElements(el)) {
            addTagToHashMap(map, el.getTagName(), getTextValue(el));
        } else {
            HashMap<String, Object> submap = new HashMap<>();
            NodeList childs = el.getChildNodes();
            for (int i = 0; i < childs.getLength(); i++) {
                if (childs.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element child = (Element) childs.item(i);
                    parseElement(submap, child);
                }
            }
            addTagToHashMap(map, el.getTagName(), submap);
        }
    }

    public XMLtoMapParser(String filename) {
        try {
            in = new FileInputStream(filename);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
    }

    public XMLtoMapParser(InputStream in) {
        this.in = in;
    }

    public Map<String, Object> parse() {
        HashMap<String, Object> res = new HashMap<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        Document doc;
        try {
            builder = factory.newDocumentBuilder();
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return Collections.emptyMap();
        }

        try {
            doc = builder.parse(in);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            return Collections.emptyMap();
        }


        Element root = doc.getDocumentElement();
        parseElement(res, root);


        return res;
    }
}
