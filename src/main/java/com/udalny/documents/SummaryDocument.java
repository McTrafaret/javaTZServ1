package com.udalny.documents;

import com.udalny.documents.paydocs.*;

import java.math.BigDecimal;
import java.util.Date;


public class SummaryDocument {
    private final int DocNum;
    private final Date DocDate;
    private final String DocGUID;
    private final String OperType;
    private final BigDecimal AmountOut;
    private final String Purpose;

    private final InfPay Inf_PAY;
    private final BankPay Bank_PAY;
    private final InfRcp Inf_RCP;
    private final BankRcp Bank_RCP;

    public SummaryDocument(Doc payDoc, com.udalny.documents.report.Doc reportDoc) {
        DocNum = reportDoc.getDocNum();
        DocDate = reportDoc.getDocDate();
        DocGUID = reportDoc.getDocGUID();
        OperType = reportDoc.getOperType();
        AmountOut = reportDoc.getAmountOut();
        Purpose = payDoc.getPurpose();
        Inf_PAY = payDoc.getInf_PAY();
        Bank_PAY = payDoc.getBank_PAY();
        Inf_RCP = payDoc.getInf_RCP();
        Bank_RCP = payDoc.getBank_RCP();
    }

    public int getDocNum() {
        return DocNum;
    }

    public Date getDocDate() {
        return DocDate;
    }

    public String getDocGUID() {
        return DocGUID;
    }

    public String getOperType() {
        return OperType;
    }

    public BigDecimal getAmountOut() {
        return AmountOut;
    }

    public String getPurpose() {
        return Purpose;
    }

    public InfPay getInf_PAY() {
        return Inf_PAY;
    }

    public BankPay getBank_PAY() {
        return Bank_PAY;
    }

    public InfRcp getInf_RCP() {
        return Inf_RCP;
    }

    public BankRcp getBank_RCP() {
        return Bank_RCP;
    }

    @Override
    public String toString() {
        return "SummaryDocument{" +
                "DocNum=" + DocNum +
                ", DocDate=" + DocDate +
                ", DocGUID='" + DocGUID + '\'' +
                ", OperType='" + OperType + '\'' +
                ", AmountOut=" + AmountOut +
                ", Purpose='" + Purpose + '\'' +
                ", Inf_PAY=" + Inf_PAY +
                ", Bank_PAY=" + Bank_PAY +
                ", Inf_RCP=" + Inf_RCP +
                ", Bank_RCP=" + Bank_RCP +
                '}';
    }
}
