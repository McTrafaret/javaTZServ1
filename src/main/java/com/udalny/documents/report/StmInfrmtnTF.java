package com.udalny.documents.report;

import com.udalny.documents.ObjectMapper;

import java.util.Map;

public class StmInfrmtnTF {
    String GUID;

    public StmInfrmtnTF(Map<String, Object> map) {
        ObjectMapper.map(this, map);
    }

    @Override
    public String toString() {
        return "StmInfrmtnTF{" +
                "GUID='" + GUID + '\'' +
                '}';
    }
}
