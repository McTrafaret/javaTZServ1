package com.udalny.documents.report;

import com.udalny.util.ObjectMapper;

import java.util.Map;

public class StmInfrmtnTF {
    String GUID;

    public StmInfrmtnTF() {
    }

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
