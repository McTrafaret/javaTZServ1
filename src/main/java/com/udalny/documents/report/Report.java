package com.udalny.documents.report;

import com.udalny.documents.ObjectMapper;
import com.udalny.documents.ServerDocument;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Report
        extends ServerDocument {

    BigInteger DocNum;
    Date DocDate;
    Date DocDateOld;
    BigInteger AccNum;
    String Report_type_flag;
    int Code_OKEU;
    String Executor_SFP;
    String Executor_Post;
    StmInfrmtnTF StmInfrmtn_TF;
    List<Doc> Docs;

    public Report(Map<String, Object> map) {

        ObjectMapper.map(this, map);

        Map<String, Object> docMap = (Map<String, Object>) map.get("Docs");
        Docs = Doc.parseDocs(docMap);

        Map<String, Object> stmMap = (Map<String, Object>) map.get("StmInfrmtn_TF");
        StmInfrmtn_TF = new StmInfrmtnTF(stmMap);
    }

    public BigInteger getDocNum() {
        return DocNum;
    }

    public Date getDocDate() {
        return DocDate;
    }

    public Date getDocDateOld() {
        return DocDateOld;
    }

    public BigInteger getAccNum() {
        return AccNum;
    }

    public String getReport_type_flag() {
        return Report_type_flag;
    }

    public int getCode_OKEU() {
        return Code_OKEU;
    }

    public String getExecutor_SFP() {
        return Executor_SFP;
    }

    public String getExecutor_Post() {
        return Executor_Post;
    }

    public StmInfrmtnTF getStmInfrmtn_TF() {
        return StmInfrmtn_TF;
    }

    public List<Doc> getDocs() {
        return Docs;
    }

    @Override
    public String toString() {
        return "Report{" +
                "DocNum=" + DocNum +
                ", DocDate=" + DocDate +
                ", DocDateOld=" + DocDateOld +
                ", AccNum=" + AccNum +
                ", Report_type_flag='" + Report_type_flag + '\'' +
                ", Code_OKEU=" + Code_OKEU +
                ", Executor_SFP='" + Executor_SFP + '\'' +
                ", Executor_Post='" + Executor_Post + '\'' +
                ", StmInfrmtn_TF=" + StmInfrmtn_TF +
                ", Docs=" + Docs +
                '}';
    }
}
