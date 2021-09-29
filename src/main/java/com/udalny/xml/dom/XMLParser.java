package com.udalny.xml.dom;

public interface XMLParser<T> {

    T parse();

    boolean applied();
}