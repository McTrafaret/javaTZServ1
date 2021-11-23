package com.udalny.xml.dom;

import com.udalny.documents.report.ReportDoc;
import com.udalny.documents.report.Report;
import com.udalny.documents.report.StmInfrmtnTF;
import com.udalny.xml.XMLParser;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
@Profile("DomParser")
public class XMLDomParserReport
        extends XMLDomParser
        implements XMLParser<Report> {

    static final String REPORT_TAG = "SKP_REPORT_KS";
    static final String UNKNOWN_TAG_WARNING = "Unknown tag found while parsing: {}";
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");


    public XMLDomParserReport() {
        super();
    }

    public ReportDoc parseDoc(Element el) {
        ReportDoc ret = new ReportDoc();

        NodeList children = el.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element docElement = (Element) children.item(i);
                try {
                    switch (docElement.getTagName()) {
                        case "Line_Num":
                            ret.setLineNum(Integer.parseInt(getTextValue(docElement)));
                            break;
                        case "DocNum":
                            ret.setDocNum(getTextValue(docElement));
                            break;
                        case "DocDate":
                            ret.setDocDate(dateFormatter.parse(getTextValue(docElement)));
                            break;
                        case "DocGUID":
                            ret.setDocGUID(getTextValue(docElement));
                            break;
                        case "OperType":
                            ret.setOperType(getTextValue(docElement));
                            break;
                        case "Bic_Corr":
                            ret.setBicCorr(getTextValue(docElement));
                            break;
                        case "AmountIn":
                            ret.setAmountIn(new BigDecimal(getTextValue(docElement)));
                            break;
                        case "AmountOut":
                            ret.setAmountOut(new BigDecimal(getTextValue(docElement)));
                            break;
                        case "SendAcc":
                            ret.setSendAcc(getTextValue(docElement));
                            break;
                        case "RecipAcc":
                            ret.setRecipAcc(getTextValue(docElement));
                            break;
                        case "PurpPay":
                            ret.setPurpPay(getTextValue(docElement));
                            break;
                        default:
                            logger.warn(UNKNOWN_TAG_WARNING, docElement.getTagName());
                            break;
                    }
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
                }
            }
        }

        return ret;

    }

    public StmInfrmtnTF parseStmInfrmtn(Element el) {
        StmInfrmtnTF res = new StmInfrmtnTF();

        NodeList children = el.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) children.item(i);
                if(child.getTagName().equals("GUID")) {
                    res.setGuid(getTextValue(child));
                }
                else {
                    logger.warn(UNKNOWN_TAG_WARNING, child.getTagName());
                }
            }
        }

        return res;

    }

    public List<ReportDoc> parseDocs(Element el) {
        List<ReportDoc> docs = new LinkedList<>();

        NodeList children = el.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element docElement = (Element) children.item(i);
                if (!docElement.getTagName().equals("Doc")) {
                    logger.info(UNKNOWN_TAG_WARNING,
                            docElement.getTagName());
                } else {
                    ReportDoc parsedDoc = parseDoc(docElement);
                    docs.add(parsedDoc);
                }
            }
        }

        return docs;
    }

    @Override
    public Report parse(Document doc) {
        Report report = new Report();
        Element root = doc.getDocumentElement();

        NodeList rootChildren = root.getChildNodes();

        for (int i = 0; i < rootChildren.getLength(); i++) {

            if (rootChildren.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) rootChildren.item(i);

                try {
                    switch (child.getTagName()) {
                        case "DocNum":
                            report.setDocNum(new BigInteger(getTextValue(child)));
                            break;
                        case "DocDate":
                            report.setDocDate(dateFormatter.parse(getTextValue(child)));
                            break;
                        case "DocDateOld":
                            report.setDocDateOld(dateFormatter.parse(getTextValue(child)));
                            break;
                        case "AccNum":
                            report.setAccNum(new BigInteger(getTextValue(child)));
                            break;
                        case "Report_type_flag":
                            report.setReportTypeFlag(getTextValue(child));
                            break;
                        case "Code_OKEU":
                            report.setCodeOKEU(Integer.parseInt(getTextValue(child)));
                            break;
                        case "Executor_SFP":
                            report.setExecutorSFP(getTextValue(child));
                            break;
                        case "Executor_Post":
                            report.setExecutorPost(getTextValue(child));
                            break;
                        case "Docs":
                            report.setDocs(parseDocs(child));
                            break;
                        case "StmInfrmtn_TF":
                            report.setStmInfrmtnTF(parseStmInfrmtn(child));
                            break;
                        default:
                            logger.warn(UNKNOWN_TAG_WARNING, child.getTagName());
                            break;
                    }
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
                }
            }
        }

        return report;

    }

    @Override
    public boolean applied(Document doc) {
        return doc.getDocumentElement().getTagName().equals(REPORT_TAG);
    }
}
