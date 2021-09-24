package com.udalny.documents;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SummaryDocumentFactory {
    private static String getGUIDFromDoc(HashMap<String, Object> map) {
        if (map.containsKey("GUID")) {
            return (String) map.get("GUID");
        } else
            return (String) map.get("DocGUID");
    }

    private static HashMap<String, HashMap<String, Object>> mapGUIDToDocs(List<HashMap<String, Object>> docs) {
        Iterator<HashMap<String, Object>> iter = docs.iterator();
        HashMap<String, HashMap<String, Object>> res = new HashMap<>();

        iter.next();
        while (iter.hasNext()) {
            HashMap<String, Object> map = iter.next();
            res.put(getGUIDFromDoc(map), map);
        }

        return res;
    }

    public static List<SummaryDocument> getListOfSummaryDocuments(Report report, PayDocs paydocs) {
        LinkedList<SummaryDocument> list = new LinkedList<>();

        List<HashMap<String, Object>> reportDocs = report.getListOfDocs();
        List<HashMap<String, Object>> paydocsDocs = paydocs.getListOfDocs();

        HashMap<String, HashMap<String, Object>> guidmap = mapGUIDToDocs(paydocsDocs);

        Iterator<HashMap<String, Object>> iter = reportDocs.iterator();

        iter.next();
        while (iter.hasNext()) {
            HashMap<String, Object> map = iter.next();
            String reportGUID = getGUIDFromDoc(map);
            if (guidmap.containsKey(reportGUID)) {
                SummaryDocument summary = new SummaryDocument(map, guidmap.get(reportGUID));
                list.add(summary);
            }
        }

        return list;
    }

    public static List<SummaryDocument> getListOfSummaryDocuments(DocumentPair pair) {
        return getListOfSummaryDocuments(pair.getReport(), pair.getPayDocs());
    }

    private SummaryDocumentFactory() {
    }
}
