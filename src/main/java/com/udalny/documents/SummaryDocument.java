package com.udalny.documents;

import java.util.HashMap;

class InfPay
{
	public String INN_PAY;
	public String KPP_PAY;
	public String CName_PAY;

	public InfPay(HashMap<String, Object> map)
	{
		INN_PAY = (String) map.get("INN_PAY");
		KPP_PAY = (String) map.get("KPP_PAY");
		CName_PAY = (String) map.get("CName_PAY");

	}

    @Override
    public String toString() {
        return "InfPay [CName_PAY=" + CName_PAY + ", INN_PAY=" + INN_PAY + ", KPP_PAY=" + KPP_PAY + "]";
    }

}

class BankPay
{
	public String BS_PAY;
	public String BIC_PAY;
	public String BS_KS_PAY;

	public BankPay(HashMap<String, Object> map)
	{
		BS_PAY = (String) map.get("BS_PAY");
		BIC_PAY = (String) map.get("BIC_PAY");
		BS_KS_PAY = (String) map.get("BS_KS_PAY");
	}

    @Override
    public String toString() {
        return "BankPay [BIC_PAY=" + BIC_PAY + ", BS_KS_PAY=" + BS_KS_PAY + ", BS_PAY=" + BS_PAY + "]";
    }
}

class InfRCP
{
	public String INN_PAY;
    public String KPP_PAY;
	public String CName_PAY;

	public InfRCP(HashMap<String, Object> map)
	{
		INN_PAY = (String) map.get("INN_PAY");
		KPP_PAY = (String) map.get("KPP_PAY");
		CName_PAY = (String) map.get("CName_PAY");

	}

	@Override
    public String toString() {
        return "InfRCP [CName_PAY=" + CName_PAY + ", INN_PAY=" + INN_PAY + ", KPP_PAY=" + KPP_PAY + "]";
    }

}

class BankRCP
{
	public String BS_PAY;
	public String BIC_PAY;
	public String BS_KS_PAY;

	public BankRCP(HashMap<String, Object> map)
	{
		BS_PAY = (String) map.get("BS_PAY");
		BIC_PAY = (String) map.get("BIC_PAY");
		BS_KS_PAY = (String) map.get("BS_KS_PAY");
	}

    @Override
    public String toString() {
        return "BankRCP [BIC_PAY=" + BIC_PAY + ", BS_KS_PAY=" + BS_KS_PAY + ", BS_PAY=" + BS_PAY + "]";
    }

}

public class SummaryDocument
{
	private String DocNum;
	private String DocDate;
	private String DocGUID;
	private String OperType;
	private String AmountOut;

	private InfPay Inf_PAY;
	private BankPay Bank_PAY;
	private InfRCP Inf_RCP;
	private BankRCP Bank_RCP;

	public SummaryDocument(HashMap<String, Object> reportDoc, HashMap<String, Object> payDoc)
	{
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
