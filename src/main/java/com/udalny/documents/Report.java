package com.udalny.documents;

import java.util.Date;
import java.util.LinkedList;
import java.util.HashMap;

public class Report
	extends ServerDocument
{

	private int DocNum;
	private Date DocDate;
	private Date DocDateOld;
	private String AccNum;
	private String ReportTypeFlag;
	private int CodeOKEU;
	private String ExecutorSFP;
	private String ExecutorPost;
	private LinkedList <HashMap<String, String>> Docs;

	public Report(HashMap<String, Object> map)
	{
		super(map);
	}

	@Override
	protected boolean compareGUID(HashMap<String, Object> map, String GUID)
	{
			if(map.containsKey("DocGUID"))
			{
				String guid = (String) map.get("DocGUID");
				return guid.equalsIgnoreCase(GUID);
			}
			else
				return false;
	}

    public int getDocNum() {
        return DocNum;
    }
    public void setDocNum(int docNum) {
        DocNum = docNum;
    }
    public Date getDocDate() {
        return DocDate;
    }
    public void setDocDate(Date docDate) {
        DocDate = docDate;
    }
    public Date getDocDateOld() {
        return DocDateOld;
    }
    public void setDocDateOld(Date docDateOld) {
        DocDateOld = docDateOld;
    }
    public String getAccNum() {
        return AccNum;
    }
    public void setAccNum(String accNum) {
        AccNum = accNum;
    }
    public String getReportTypeFlag() {
        return ReportTypeFlag;
    }
    public void setReportTypeFlag(String reportTypeFlag) {
        ReportTypeFlag = reportTypeFlag;
    }
    public int getCodeOKEU() {
        return CodeOKEU;
    }
    public void setCodeOKEU(int codeOKEU) {
        CodeOKEU = codeOKEU;
    }
    public String getExecutorSFP() {
        return ExecutorSFP;
    }
    public void setExecutorSFP(String executorSFP) {
        ExecutorSFP = executorSFP;
    }
    public String getExecutorPost() {
        return ExecutorPost;
    }
    public void setExecutorPost(String executorPost) {
        ExecutorPost = executorPost;
    }
    public LinkedList<HashMap<String, String>> getDocs() {
        return Docs;
    }
    public void setDocs(LinkedList<HashMap<String, String>> docs) {
        Docs = docs;
    }
}
