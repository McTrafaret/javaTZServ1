package com.udalny.xml;

import com.udalny.exceptions.ParseException;

public interface Parser<T> {

    T parse(String doc) throws ParseException;

    boolean applied(String doc);
}
