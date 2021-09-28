package com.udalny.documents.paydocs;

import com.udalny.documents.ObjectMapper;

import java.util.Map;

public class InfRcp {
    private String INN_PAY;
    private String KPP_PAY;
    private String CName_PAY;

    public InfRcp(Map<String, Object> map) {
        ObjectMapper.map(this, map);
    }

    public String getINN_PAY() {
        return INN_PAY;
    }

    public String getKPP_PAY() {
        return KPP_PAY;
    }

    public String getCName_PAY() {
        return CName_PAY;
    }

    @Override
    public String toString() {
        return "InfRcp{" +
                "INN_PAY='" + INN_PAY + '\'' +
                ", KPP_PAY='" + KPP_PAY + '\'' +
                ", CName_PAY='" + CName_PAY + '\'' +
                '}';
    }
}
