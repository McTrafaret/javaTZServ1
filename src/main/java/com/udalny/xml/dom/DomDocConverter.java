package com.udalny.xml.dom;

import com.udalny.xml.DocConverter;
import com.udalny.xml.XMLParser;
import org.apache.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public final class DomDocConverter
        extends DocConverter {

    private static Logger logger = Logger.getLogger(DomDocConverter.class);
    private static final DomDocConverter instance = new DomDocConverter();
    private Set<XMLParser<?>> parsers = new HashSet<>();


    private DomDocConverter() {
        parsers.add(new XMLDomParserPayDocs());
        parsers.add(new XMLDomParserReport());
    }

    public static DomDocConverter getInstance() {
        return instance;
    }

}
