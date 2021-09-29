package com.udalny.documents;

import com.udalny.documents.paydocs.PayDocs;
import com.udalny.documents.report.Report;
import com.udalny.xml.XMLtoMapParser;

import java.io.InputStream;
import java.util.Map;

public class ServerDocumentFactory {
    private static final String PAY_DOCS_TAG = "Inf_Pay_Doc";
    private static final String REPORT_TAG = "SKP_REPORT_KS";

    public static ServerDocument getDocument(Map<String, Object> map) {
        if (map.containsKey(PAY_DOCS_TAG))
            return new PayDocs((Map<String, Object>) map.get(PAY_DOCS_TAG));
        else if (map.containsKey(REPORT_TAG))
            return new Report((Map<String, Object>) map.get(REPORT_TAG));

        return null;
    }

    public static ServerDocument getDocument(String xmlFilename) {
        XMLtoMapParser parser = new XMLtoMapParser(xmlFilename);
        Map<String, Object> map = parser.parse();
        return getDocument(map);
    }

    public static ServerDocument getDocument(InputStream in) {
        XMLtoMapParser parser = new XMLtoMapParser(in);
        Map<String, Object> map = parser.parse();
        return getDocument(map);
    }

    private ServerDocumentFactory() {

    }
}
