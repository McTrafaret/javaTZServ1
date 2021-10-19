package com.udalny.documents;

import com.udalny.exceptions.DocumentSetException;
import com.udalny.exceptions.ParseException;

import java.util.List;

public class DocumentSetStringBuilder
        implements DocumentSetBuilder<String> {

    private List<ServerDocument> documents;

    public void addDocument(String content)
            throws ParseException {
        documents.add(ServerDocumentFactory.createDocument(content));
    }

    public void addDocuments(List<String> files)
            throws ParseException {
        for (String content : files) {
            addDocument(content);
        }
    }

    public DocumentSet createDocumentSet()
            throws DocumentSetException {
        return new DocumentSet(documents);
    }
}
