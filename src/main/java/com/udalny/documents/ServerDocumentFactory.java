package com.udalny.documents;

import com.udalny.xml.DOMXMLParser;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ServerDocumentFactory {
    private static final String PAY_DOCS_TAG = "Inf_Pay_Doc";
    private static final String REPORT_TAG = "SKP_REPORT_KS";

    public static ServerDocument getDocument(Map<String, Object> map) {
        if (map.containsKey(PAY_DOCS_TAG))
            return new PayDocs((HashMap<String, Object>) map.get(PAY_DOCS_TAG));
        else if (map.containsKey(REPORT_TAG))
            return new Report((HashMap<String, Object>) map.get(REPORT_TAG));

        return null;
    }

    public static ServerDocument getDocument(String xmlFilename) {
        DOMXMLParser parser = new DOMXMLParser(xmlFilename);
        Map<String, Object> map = parser.parse();
        return getDocument(map);
    }

    public static ServerDocument getDocument(InputStream in) {
        DOMXMLParser parser = new DOMXMLParser(in);
        Map<String, Object> map = parser.parse();
        return getDocument(map);
    }

    private ServerDocumentFactory() {

    }
}
