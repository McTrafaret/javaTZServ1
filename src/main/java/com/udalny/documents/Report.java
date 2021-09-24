package com.udalny.documents;

import java.util.HashMap;

public class Report
        extends ServerDocument {

    public Report(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected boolean compareGUID(HashMap<String, Object> map, String guid) {
        if (map.containsKey("DocGUID")) {
            String mapguid = (String) map.get("DocGUID");
            return mapguid.equalsIgnoreCase(guid);
        } else
            return false;
    }
}
