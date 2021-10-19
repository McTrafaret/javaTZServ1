package com.udalny.xml.dom;

import com.udalny.xml.DocConverter;
import com.udalny.xml.XMLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("DomParser")
public final class DomDocConverter
        extends DocConverter {

    @Autowired
    private DomDocConverter(List<XMLParser<?>> parsers) {
        this.parsers = parsers;
    }

}
