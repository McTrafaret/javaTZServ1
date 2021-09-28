package com.udalny;

import com.udalny.documents.DocumentPair;
import com.udalny.documents.SummaryDocument;
import com.udalny.documents.SummaryDocumentFactory;
import com.udalny.documents.ZipHandler;

import java.util.List;

public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please specify zip file");
            return;
        }

        try {
            ZipHandler zipHandler = new ZipHandler(args[0]);
            DocumentPair documentPair = zipHandler.getDocuments();
            List<SummaryDocument> list = SummaryDocumentFactory.createListOfSummaryDocuments(documentPair);
            System.out.print(list);
        } catch (Exception ex) {
            System.err.println(ex);
        }

    }
}
