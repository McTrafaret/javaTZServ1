package com.udalny.documents.paydocs;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@XmlRootElement(name = "Doc")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayDoc {

    @XmlElement(name = "Num")
    private int num;
    @XmlElement(name = "Date")
    private Date date;
    @XmlElement(name = "ID")
    private BigInteger id;
    @XmlElement(name = "Nom_PP")
    private int nomPp;
    @XmlElement(name = "Date_PP")
    private Date datePp;
    @XmlElement(name = "Sum_PP")
    private BigDecimal sumPp;
    @XmlAttribute(name = "Vid_Pay")
    private String vidPay;
    @XmlElement(name = "Date_PP_IN")
    private Date datePpIn;
    @XmlElement(name = "Date_PP_OUT")
    private Date datePpOut;
    @XmlElement(name = "VID_Oper")
    private String vidOper;
    @XmlElement(name = "Inf_PAY", type = InfPay.class)
    private InfPay infPay;
    @XmlElement(name = "Bank_PAY", type = BankPay.class)
    private BankPay bankPay;
    @XmlElement(name = "Inf_RCP", type = InfRcp.class)
    private InfRcp infRcp;
    @XmlElement(name = "Bank_RCP", type = BankRcp.class)
    private BankRcp bankRcp;
    @XmlElement(name = "Purpose_ID")
    private int purposeId;
    @XmlElement(name = "Order_PAY")
    private String orderPay;
    @XmlElement(name = "UIN")
    private String uin;
    @XmlElement(name = "Purpose")
    private String purpose;
    @XmlElement(name = "Type_Pl")
    private String typePl;
    @XmlElement(name = "Date_IN_TOFK")
    private Date dateInTofk;
    @XmlElement(name = "GUID")
    private String guid;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public int getNomPp() {
        return nomPp;
    }

    public void setNomPp(int nomPp) {
        this.nomPp = nomPp;
    }

    public Date getDatePp() {
        return datePp;
    }

    public void setDatePp(Date datePp) {
        this.datePp = datePp;
    }

    public BigDecimal getSumPp() {
        return sumPp;
    }

    public void setSumPp(BigDecimal sumPp) {
        this.sumPp = sumPp;
    }

    public String getVidPay() {
        return vidPay;
    }

    public void setVidPay(String vidPay) {
        this.vidPay = vidPay;
    }

    public Date getDatePpIn() {
        return datePpIn;
    }

    public void setDatePpIn(Date datePpIn) {
        this.datePpIn = datePpIn;
    }

    public Date getDatePpOut() {
        return datePpOut;
    }

    public void setDatePpOut(Date datePpOut) {
        this.datePpOut = datePpOut;
    }

    public String getVidOper() {
        return vidOper;
    }

    public void setVidOper(String vidOper) {
        this.vidOper = vidOper;
    }

    public InfPay getInfPay() {
        return infPay;
    }

    public void setInfPay(InfPay infPay) {
        this.infPay = infPay;
    }

    public BankPay getBankPay() {
        return bankPay;
    }

    public void setBankPay(BankPay bankPay) {
        this.bankPay = bankPay;
    }

    public InfRcp getInfRcp() {
        return infRcp;
    }

    public void setInfRcp(InfRcp infRcp) {
        this.infRcp = infRcp;
    }

    public BankRcp getBankRcp() {
        return bankRcp;
    }

    public void setBankRcp(BankRcp bankRcp) {
        this.bankRcp = bankRcp;
    }

    public int getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(int purposeId) {
        this.purposeId = purposeId;
    }

    public String getOrderPay() {
        return orderPay;
    }

    public void setOrderPay(String orderPay) {
        this.orderPay = orderPay;
    }

    public String getUin() {
        return uin;
    }

    public void setUin(String uin) {
        this.uin = uin;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getTypePl() {
        return typePl;
    }

    public void setTypePl(String typePl) {
        this.typePl = typePl;
    }

    public Date getDateInTofk() {
        return dateInTofk;
    }

    public void setDateInTofk(Date dateInTofk) {
        this.dateInTofk = dateInTofk;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public String toString() {
        return "Doc{" +
                "num=" + num +
                ", date=" + date +
                ", id=" + id +
                ", nomPp=" + nomPp +
                ", datePp=" + datePp +
                ", sumPp=" + sumPp +
                ", vidPay='" + vidPay + '\'' +
                ", datePpIn=" + datePpIn +
                ", datePpOut=" + datePpOut +
                ", vidOper='" + vidOper + '\'' +
                ", infPay=" + infPay +
                ", bankPay=" + bankPay +
                ", infRcp=" + infRcp +
                ", bankRcp=" + bankRcp +
                ", purposeId=" + purposeId +
                ", orderPay='" + orderPay + '\'' +
                ", uin='" + uin + '\'' +
                ", purpose='" + purpose + '\'' +
                ", typePl='" + typePl + '\'' +
                ", dateInTofk=" + dateInTofk +
                ", guid='" + guid + '\'' +
                '}';
    }
}
