package com.udalny.documents;

import com.udalny.documents.paydocs.PayDocs;
import com.udalny.documents.report.Report;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SummaryDocumentFactory {

    public static List<SummaryDocument> createListOfSummaryDocuments(Report report, PayDocs paydocs) {
        LinkedList<SummaryDocument> list = new LinkedList<>();

        List<com.udalny.documents.report.Doc> reportDocs = report.getDocs();
        List<com.udalny.documents.paydocs.Doc> payDocs = paydocs.getDocs();

        HashMap<String, com.udalny.documents.report.Doc> guidMap = new HashMap<>();

        Iterator<com.udalny.documents.report.Doc> i = reportDocs.iterator();
        while (i.hasNext()) {
            com.udalny.documents.report.Doc doc = i.next();
            guidMap.put(doc.getDocGUID(), doc);
        }

        Iterator<com.udalny.documents.paydocs.Doc> iter = payDocs.iterator();
        while (iter.hasNext()) {
            com.udalny.documents.paydocs.Doc doc = iter.next();
            if (guidMap.containsKey(doc.getGUID())) {
               list.add(new SummaryDocument(doc, guidMap.get(doc.getGUID())));
            }
        }

        return list;
    }

    public static List<SummaryDocument> createListOfSummaryDocuments(DocumentSet pair) {
        return createListOfSummaryDocuments(pair.getReport(), pair.getPayDocs());
    }

//    public static List<SummaryDocument> createListOfSummaryDocuments();

    private SummaryDocumentFactory() {
    }
}
