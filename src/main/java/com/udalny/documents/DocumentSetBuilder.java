package com.udalny.documents;

import com.udalny.exceptions.DocumentSetException;
import com.udalny.exceptions.ParseException;

public interface DocumentSetBuilder<T> {

    public DocumentSet createDocumentSet() throws DocumentSetException;
    public void addDocument(T contents) throws ParseException;
}
