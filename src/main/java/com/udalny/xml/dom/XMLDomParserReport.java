package com.udalny.xml.dom;

import com.udalny.exceptions.FieldMapException;
import com.udalny.documents.report.Doc;
import com.udalny.documents.report.Report;
import com.udalny.documents.report.StmInfrmtnTF;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;

public class XMLDomParserReport
        extends XMLDomParser
        implements XMLParser<Report> {

    static final String REPORT_TAG = "SKP_REPORT_KS";
    static final String NOT_REPORT_ERROR = "The file is not valid Report document";

    public XMLDomParserReport() {
        super();
    }

    public Doc parseDoc(Element el) {
        Doc ret = new Doc();

        parseObject(ret, el);

        return ret;

    }

    public StmInfrmtnTF parseStmInfrmtn(Element el) {
        StmInfrmtnTF res = new StmInfrmtnTF();

        parseObject(res, el);

        return res;

    }

    public List<Doc> parseDocs(Element el) {
        List<Doc> docs = new LinkedList<>();

        NodeList children = el.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element docElement = (Element) children.item(i);
                if (!docElement.getTagName().equals("Doc")) {
                    logger.info(String.format("Unknown entry %s, while parsing Report Doc",
                            docElement.getTagName()));
                } else {
                    Doc parsedDoc = parseDoc(docElement);
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

                if (child.getTagName().equals("Docs"))
                    report.setDocs(parseDocs(child));

                else if (child.getTagName().equals("StmInfrmtn_TF"))
                    report.setStmInfrmtn_TF(parseStmInfrmtn(child));

                else {
                    try {
                        checkFieldAndSet(report, child);
                    } catch (FieldMapException ex) {
                        logger.error(ex);
                    }
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
