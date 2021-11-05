package com.udalny.xml.dom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class XMLDomParser {

    protected Logger logger;

    protected XMLDomParser() {
        logger = LoggerFactory.getLogger(this.getClass());
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

}
