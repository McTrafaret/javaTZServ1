package com.udalny.xml;

import com.udalny.exceptions.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;


@Service
public class XMLParserAdapter<T>
        implements Parser<T> {

    private XMLParser<T> xmlParser;

    @Autowired
    public XMLParserAdapter(XMLParser<T> xmlParser) {
        this.xmlParser = xmlParser;
    }

    @Override
    public T parse(String doc) throws ParseException {
        try {
            Document xmldoc = StringToDocumentConverter.convert(doc);
            return xmlParser.parse(xmldoc);
        } catch (Exception ex) {
            throw new ParseException("File is not applicable", ex);
        }

    }

    @Override
    public boolean applied(String doc) {
        try {
            Document xmldoc = StringToDocumentConverter.convert(doc);
            return xmlParser.applied(xmldoc);
        } catch (Exception ex) {
            return false;
        }
    }


}