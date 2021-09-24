package com.udalny.documents;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class ServerDocument {
    private final HashMap<String, Object> map;

    protected abstract boolean compareGUID(HashMap<String, Object> map, String guid);

    protected ServerDocument(HashMap<String, Object> map) {
        this.map = map;
    }

    public Map<String, Object> getDocByGUID(String guid) {
        Object temp;
        HashMap<String, Object> ret;

        if (map == null)
            return Collections.emptyMap();


        ret = (HashMap<String, Object>) map.get("Docs");
        temp = ret.get("Doc");
        if (temp instanceof LinkedList<?>) {
            LinkedList<HashMap<String, Object>> list =
                    (LinkedList<HashMap<String, Object>>) temp;
            Iterator<HashMap<String, Object>> iter = list.iterator();
            iter.next();
            while (iter.hasNext()) {
                ret = iter.next();
                if (compareGUID(ret, guid))
                    return ret;
            }
            return Collections.emptyMap();
        } else {
            ret = (HashMap<String, Object>) temp;
            if (compareGUID(ret, guid))
                return ret;
            else
                return Collections.emptyMap();
        }
    }

    public List<HashMap<String, Object>> getListOfDocs() {
        LinkedList<HashMap<String, Object>> ret;
        HashMap<String, Object> tempmap;
        Object temp;

        if (map == null)
            return Collections.emptyList();

        tempmap = (HashMap<String, Object>) map.get("Docs");
        temp = tempmap.get("Doc");
        if (temp instanceof LinkedList<?>) {
            return (LinkedList<HashMap<String, Object>>) temp;
        } else {
            ret = new LinkedList<>();
            ret.add((HashMap<String, Object>) temp);
        }

        return ret;
    }
}
