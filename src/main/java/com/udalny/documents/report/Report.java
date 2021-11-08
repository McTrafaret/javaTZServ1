package com.udalny.documents.report;

import com.udalny.documents.ServerDocument;
import jakarta.xml.bind.annotation.*;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "SKP_REPORT_KS")
@XmlAccessorType(XmlAccessType.FIELD)
public class Report
        extends ServerDocument {

    @XmlElement(name = "DocNum")
    private BigInteger docNum;
    @XmlElement(name = "DocDate")
    private Date docDate;
    @XmlElement(name = "DocDateOld")
    private Date docDateOld;
    @XmlElement(name = "AccNum")
    private BigInteger accNum;
    @XmlElement(name = "Report_type_flag")
    private String reportTypeFlag;
    @XmlElement(name = "Code_OKEU")
    private int codeOKEU;
    @XmlElement(name = "Executor_SFP")
    private String executorSFP;
    @XmlElement(name = "Executor_Post")
    private String executorPost;
    @XmlElement(name = "StmInfrmtn_TF", type = StmInfrmtnTF.class)
    private StmInfrmtnTF stmInfrmtnTF;
    @XmlElementWrapper(name = "Docs")
    @XmlElement(name = "Doc", type = ReportDoc.class)
    private List<ReportDoc> docs;

    public BigInteger getDocNum() {
        return docNum;
    }

    public void setDocNum(BigInteger docNum) {
        this.docNum = docNum;
    }

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }

    public Date getDocDateOld() {
        return docDateOld;
    }

    public void setDocDateOld(Date docDateOld) {
        this.docDateOld = docDateOld;
    }

    public BigInteger getAccNum() {
        return accNum;
    }

    public void setAccNum(BigInteger accNum) {
        this.accNum = accNum;
    }

    public String getReportTypeFlag() {
        return reportTypeFlag;
    }

    public void setReportTypeFlag(String reportTypeFlag) {
        this.reportTypeFlag = reportTypeFlag;
    }

    public int getCodeOKEU() {
        return codeOKEU;
    }

    public void setCodeOKEU(int codeOKEU) {
        this.codeOKEU = codeOKEU;
    }

    public String getExecutorSFP() {
        return executorSFP;
    }

    public void setExecutorSFP(String executorSFP) {
        this.executorSFP = executorSFP;
    }

    public String getExecutorPost() {
        return executorPost;
    }

    public void setExecutorPost(String executorPost) {
        this.executorPost = executorPost;
    }

    public StmInfrmtnTF getStmInfrmtnTF() {
        return stmInfrmtnTF;
    }

    public void setStmInfrmtnTF(StmInfrmtnTF stmInfrmtnTF) {
        this.stmInfrmtnTF = stmInfrmtnTF;
    }

    public List<ReportDoc> getDocs() {
        return docs;
    }

    public void setDocs(List<ReportDoc> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        return "Report{" +
                "docNum=" + docNum +
                ", docDate=" + docDate +
                ", docDateOld=" + docDateOld +
                ", accNum=" + accNum +
                ", reportTypeFlag='" + reportTypeFlag + '\'' +
                ", codeOKEU=" + codeOKEU +
                ", executorSFP='" + executorSFP + '\'' +
                ", executorPost='" + executorPost + '\'' +
                ", stmInfrmtnTF=" + stmInfrmtnTF +
                ", docs=" + docs +
                '}';
    }
}
