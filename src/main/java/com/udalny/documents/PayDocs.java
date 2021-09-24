package com.udalny.documents;

import java.util.HashMap;

public class PayDocs
        extends ServerDocument {
    public PayDocs(HashMap<String, Object> map) {
        super(map);
    }

    @Override
    protected boolean compareGUID(HashMap<String, Object> map, String guid) {
        if (map.containsKey("GUID")) {
            String mapguid = (String) map.get("GUID");
            return mapguid.equalsIgnoreCase(guid);
        } else
            return false;
    }
}
