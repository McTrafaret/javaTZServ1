package com.udalny.xml;

import com.udalny.exceptions.ParseException;
import org.w3c.dom.Document;

public interface XMLParser<T> {

    T parse(Document doc) throws ParseException;

    boolean applied(Document doc);
}