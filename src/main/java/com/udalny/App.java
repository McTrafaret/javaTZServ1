package com.udalny;

import com.udalny.documents.DocumentPair;
import com.udalny.documents.SummaryDocument;
import com.udalny.documents.SummaryDocumentFactory;
import com.udalny.documents.ZipHandler;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please specify zip file");
            return;
        }

        DocumentPair pair;
        ZipHandler zipHandler = new ZipHandler(args[0]);
        try {
            pair = zipHandler.getDocuments();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return;
        }
        List<SummaryDocument> sum = SummaryDocumentFactory.getListOfSummaryDocuments(pair);
        System.out.println(sum);

    }
}
