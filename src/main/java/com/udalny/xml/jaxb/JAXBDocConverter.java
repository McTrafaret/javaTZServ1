package com.udalny.xml.jaxb;

import com.udalny.xml.DocConverter;
import com.udalny.xml.XMLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("JAXBParser")
public final class JAXBDocConverter
    extends DocConverter {

    @Autowired
    private JAXBDocConverter(List<XMLParser<?>> parsers) {
        this.parsers = parsers;
    }

}
