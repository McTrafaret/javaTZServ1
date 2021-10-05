package com.udalny.xml.dom;

import com.udalny.documents.exceptions.FieldMapException;
import com.udalny.util.ObjectMapper;
import org.apache.log4j.Logger;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public abstract class XMLDomParser {

    protected Logger logger;


    protected XMLDomParser() {
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

    protected <T> void checkFieldAndSet(T obj, Element el)
            throws FieldMapException {
        if (!hasChildElements(el)) {
            String val = getTextValue(el);
            if (val.isEmpty()) {
                val = el.getAttribute("value");
            }
            ObjectMapper.mapStringValueToField(obj, el.getTagName(), val);
        } else {
            unknownFieldMessage(el.getTagName());
        }

    }

    protected <T> void parseObject(T obj, Element el) {

        NodeList children = el.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                try {
                    checkFieldAndSet(obj, (Element) children.item(i));
                } catch (FieldMapException ex) {
                    logger.error(ex);
                }
            }
        }
    }

}
