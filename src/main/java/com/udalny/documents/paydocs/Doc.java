package com.udalny.documents.paydocs;

import com.udalny.util.ObjectMapper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Doc
        implements Comparable<com.udalny.documents.report.Doc> {

    private int Num;
    private Date Date;
    private BigInteger ID;
    private int Nom_PP;
    private Date Date_PP;
    private BigDecimal Sum_PP;
    private String Vid_Pay;
    private Date Date_PP_IN;
    private Date Date_PP_OUT;
    private String VID_Oper;
    private InfPay Inf_PAY;
    private BankPay Bank_PAY;
    private InfRcp Inf_RCP;
    private BankRcp Bank_RCP;
    private int Purpose_ID;
    private String Order_PAY;
    private String UIN;
    private String Purpose;
    private String Type_Pl;
    private Date Date_IN_TOFK;
    private String GUID;

    @Override
    public int compareTo(com.udalny.documents.report.Doc other) {
        return GUID.compareTo(other.getDocGUID());
    }

    public static List<Doc> parseDocs(Map<String, Object> map) {
        LinkedList<Doc> ret = new LinkedList<>();
        LinkedList<Object> docs = (LinkedList<Object>) map.get("Doc");
        Iterator<Object> iter = docs.iterator();
        iter.next();
        while (iter.hasNext()) {
            Map<String, Object> docMap = (Map<String, Object>) iter.next();
            ret.add(new Doc(docMap));
        }

        return ret;
    }

    public Doc() {
    }

    public Doc(Map<String, Object> map) {
        ObjectMapper.map(this, map);

        Map<String, Object> infPayMap = (Map<String, Object>) map.get("Inf_PAY");
        Inf_PAY = new InfPay(infPayMap);

        Map<String, Object> bankPayMap = (Map<String, Object>) map.get("Bank_PAY");
        Bank_PAY = new BankPay(bankPayMap);

        Map<String, Object> infRcpMap = (Map<String, Object>) map.get("Inf_RCP");
        Inf_RCP = new InfRcp(infRcpMap);

        Map<String, Object> bankRcpMap = (Map<String, Object>) map.get("Bank_RCP");
        Bank_RCP = new BankRcp(bankRcpMap);

    }

    public void setInf_PAY(InfPay inf_PAY) {
        Inf_PAY = inf_PAY;
    }

    public void setBank_PAY(BankPay bank_PAY) {
        Bank_PAY = bank_PAY;
    }

    public void setInf_RCP(InfRcp inf_RCP) {
        Inf_RCP = inf_RCP;
    }

    public void setBank_RCP(BankRcp bank_RCP) {
        Bank_RCP = bank_RCP;
    }

    public int getNum() {
        return Num;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public BigInteger getID() {
        return ID;
    }

    public int getNom_PP() {
        return Nom_PP;
    }

    public java.util.Date getDate_PP() {
        return Date_PP;
    }

    public BigDecimal getSum_PP() {
        return Sum_PP;
    }

    public String getVid_Pay() {
        return Vid_Pay;
    }

    public java.util.Date getDate_PP_IN() {
        return Date_PP_IN;
    }

    public java.util.Date getDate_PP_OUT() {
        return Date_PP_OUT;
    }

    public String getVID_Oper() {
        return VID_Oper;
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

    public int getPurpose_ID() {
        return Purpose_ID;
    }

    public String getOrder_PAY() {
        return Order_PAY;
    }

    public String getUIN() {
        return UIN;
    }

    public String getPurpose() {
        return Purpose;
    }

    public String getType_Pl() {
        return Type_Pl;
    }

    public java.util.Date getDate_IN_TOFK() {
        return Date_IN_TOFK;
    }

    public String getGUID() {
        return GUID;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "Num=" + Num +
                ", Date=" + Date +
                ", ID=" + ID +
                ", Nom_PP=" + Nom_PP +
                ", Date_PP=" + Date_PP +
                ", Sum_PP=" + Sum_PP +
                ", Vid_Pay='" + Vid_Pay + '\'' +
                ", Date_PP_IN=" + Date_PP_IN +
                ", Date_PP_OUT=" + Date_PP_OUT +
                ", VID_Oper='" + VID_Oper + '\'' +
                ", Inf_PAY=" + Inf_PAY +
                ", Bank_PAY=" + Bank_PAY +
                ", Inf_RCP=" + Inf_RCP +
                ", Bank_RCP=" + Bank_RCP +
                ", Purpose_ID=" + Purpose_ID +
                ", Order_PAY='" + Order_PAY + '\'' +
                ", UIN='" + UIN + '\'' +
                ", Purpose='" + Purpose + '\'' +
                ", Type_Pl='" + Type_Pl + '\'' +
                ", Date_IN_TOFK=" + Date_IN_TOFK +
                ", GUID='" + GUID + '\'' +
                '}';
    }
}
