package com.udalny.xml;

import com.udalny.exceptions.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocConverter {

    @Autowired
    private List<Parser<?>> parsers;


    public <T> T parse(String doc)
            throws ParseException {
        try {
            for (Parser<?> parser : parsers) {
                if (parser.applied(doc)) {
                    return (T) parser.parse(doc);
                }
            }
        } catch (Exception ex) {
            throw new ParseException(ex);
        }
        throw new ParseException("The file is not applicable to any of the parsers.");
    }

}
