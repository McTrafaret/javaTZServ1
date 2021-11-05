package com.udalny.documents;

import com.udalny.documents.paydocs.*;

import java.math.BigDecimal;
import java.util.Date;


public class SummaryDocument {
    private final int docNum;
    private final Date docDate;
    private final String docGuid;
    private final String operType;
    private final BigDecimal amountOut;
    private final String purpose;

    private final InfPay infPay;
    private final BankPay bankPay;
    private final InfRcp infRcp;
    private final BankRcp bankRcp;

    public SummaryDocument(Doc payDoc, com.udalny.documents.report.Doc reportDoc) {
        docNum = reportDoc.getDocNum();
        docDate = reportDoc.getDocDate();
        docGuid = reportDoc.getDocGUID();
        operType = reportDoc.getOperType();
        amountOut = reportDoc.getAmountOut();
        purpose = payDoc.getPurpose();
        infPay = payDoc.getInfPay();
        bankPay = payDoc.getBankPay();
        infRcp = payDoc.getInfRcp();
        bankRcp = payDoc.getBankRcp();
    }

    public int getDocNum() {
        return docNum;
    }

    public Date getDocDate() {
        return docDate;
    }

    public String getDocGuid() {
        return docGuid;
    }

    public String getOperType() {
        return operType;
    }

    public BigDecimal getAmountOut() {
        return amountOut;
    }

    public String getPurpose() {
        return purpose;
    }

    public InfPay getInfPay() {
        return infPay;
    }

    public BankPay getBankPay() {
        return bankPay;
    }

    public InfRcp getInfRcp() {
        return infRcp;
    }

    public BankRcp getBankRcp() {
        return bankRcp;
    }

    @Override
    public String toString() {
        return "SummaryDocument{" +
                "docNum=" + docNum +
                ", docDate=" + docDate +
                ", docGuid='" + docGuid + '\'' +
                ", operType='" + operType + '\'' +
                ", amountOut=" + amountOut +
                ", purpose='" + purpose + '\'' +
                ", infPay=" + infPay +
                ", bankPay=" + bankPay +
                ", infRcp=" + infRcp +
                ", bankRcp=" + bankRcp +
                '}';
    }
}
