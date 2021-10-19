package com.udalny.documents;


import com.udalny.exceptions.ParseException;
import com.udalny.xml.DocConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

@Component
public class ServerDocumentFactory {

    private static DocConverter converter;

    private ServerDocumentFactory() {
    }

    @Autowired
    private ServerDocumentFactory(DocConverter converter) {
        ServerDocumentFactory.converter = converter;
    }

    public static List<ServerDocument> createListOfServerDocumentsFromFileContents(List<String> contents)
            throws ParseException {

        List<ServerDocument> documents = new LinkedList<>();
        for (String content : contents) {
            ServerDocument doc = converter.parse(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8)));
            documents.add(doc);
        }

        return documents;
    }

    public static ServerDocument createDocument(String fileContents)
            throws ParseException {
            return converter.parse(new ByteArrayInputStream(fileContents.getBytes(StandardCharsets.UTF_8)));
    }

}
