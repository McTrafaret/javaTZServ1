package com.udalny.xml.jaxb;

import jakarta.xml.bind.JAXBException;
import org.w3c.dom.Document;

public interface XMLParser<T> {

    T parse(Document doc) throws JAXBException;

    boolean applied(Document doc);
}