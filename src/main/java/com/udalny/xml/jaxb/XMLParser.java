package com.udalny.xml.jaxb;

import org.w3c.dom.Document;

public interface XMLParser<T> {

    T parse(Document doc);

    boolean applied(Document doc);
}