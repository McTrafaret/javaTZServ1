package com.udalny.documents;

import java.util.HashMap;
import java.util.Map;

class InfPay {
    public final String INN_PAY;
    public final String KPP_PAY;
    public final String CName_PAY;

    public InfPay(Map<String, Object> map) {
        INN_PAY = (String) map.get("INN_PAY");
        KPP_PAY = (String) map.get("KPP_PAY");
        CName_PAY = (String) map.get("CName_PAY");

    }

    @Override
    public String toString() {
        return "InfPay [CName_PAY=" + CName_PAY + ", INN_PAY=" + INN_PAY + ", KPP_PAY=" + KPP_PAY + "]";
    }

}

class BankPay {
    public final String BS_PAY;
    public final String BIC_PAY;
    public final String BS_KS_PAY;

    public BankPay(Map<String, Object> map) {
        BS_PAY = (String) map.get("BS_PAY");
        BIC_PAY = (String) map.get("BIC_PAY");
        BS_KS_PAY = (String) map.get("BS_KS_PAY");
    }

    @Override
    public String toString() {
        return "BankPay [BIC_PAY=" + BIC_PAY + ", BS_KS_PAY=" + BS_KS_PAY + ", BS_PAY=" + BS_PAY + "]";
    }
}

class InfRCP {
    public final String INN_PAY;
    public final String KPP_PAY;
    public final String CName_PAY;

    public InfRCP(Map<String, Object> map) {
        INN_PAY = (String) map.get("INN_PAY");
        KPP_PAY = (String) map.get("KPP_PAY");
        CName_PAY = (String) map.get("CName_PAY");

    }

    @Override
    public String toString() {
        return "InfRCP [CName_PAY=" + CName_PAY + ", INN_PAY=" + INN_PAY + ", KPP_PAY=" + KPP_PAY + "]";
    }

}

class BankRCP {
    public final String BS_PAY;
    public final String BIC_PAY;
    public final String BS_KS_PAY;

    public BankRCP(Map<String, Object> map) {
        BS_PAY = (String) map.get("BS_PAY");
        BIC_PAY = (String) map.get("BIC_PAY");
        BS_KS_PAY = (String) map.get("BS_KS_PAY");
    }

    @Override
    public String toString() {
        return "BankRCP [BIC_PAY=" + BIC_PAY + ", BS_KS_PAY=" + BS_KS_PAY + ", BS_PAY=" + BS_PAY + "]";
    }

}

public class SummaryDocument {
    private final String DocNum;
    private final String DocDate;
    private final String DocGUID;
    private final String OperType;
    private final String AmountOut;

    private final InfPay Inf_PAY;
    private final BankPay Bank_PAY;
    private final InfRCP Inf_RCP;
    private final BankRCP Bank_RCP;

    public SummaryDocument(Map<String, Object> reportDoc, Map<String, Object> payDoc) {
        DocNum = (String) reportDoc.get("DocNum");
        DocDate = (String) reportDoc.get("DocDate");
        DocGUID = (String) reportDoc.get("DocGUID");
        OperType = (String) reportDoc.get("OperType");
        AmountOut = (String) reportDoc.get("AmountOut");

        Inf_PAY = new InfPay((HashMap<String, Object>) payDoc.get("Inf_PAY"));
        Bank_PAY = new BankPay((HashMap<String, Object>) payDoc.get("Bank_PAY"));
        Inf_RCP = new InfRCP((HashMap<String, Object>) payDoc.get("Inf_RCP"));
        Bank_RCP = new BankRCP((HashMap<String, Object>) payDoc.get("Bank_RCP"));
    }

    @Override
    public String toString() {
        return "SummaryDocument [AmountOut=" + AmountOut + ", Bank_PAY=" + Bank_PAY + ", Bank_RCP=" + Bank_RCP
                + ", DocDate=" + DocDate + ", DocGUID=" + DocGUID + ", DocNum=" + DocNum + ", Inf_PAY=" + Inf_PAY
                + ", Inf_RCP=" + Inf_RCP + ", OperType=" + OperType + "]";
    }

}
