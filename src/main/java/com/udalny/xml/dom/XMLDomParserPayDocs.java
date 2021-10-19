package com.udalny.xml.dom;

import com.udalny.exceptions.FieldMapException;
import com.udalny.documents.paydocs.*;
import com.udalny.xml.XMLParser;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.LinkedList;
import java.util.List;

@Service
@Profile("DomParser")
public class XMLDomParserPayDocs
        extends XMLDomParser
        implements XMLParser<PayDocs> {

    static final String PAYDOCS_TAG = "Inf_Pay_Doc";
    static final String NOT_PAYDOCS_ERROR = "The file is not a valid PayDocs document";

    public XMLDomParserPayDocs() {
        super();
    }

    private InfPay parseInfPay(Element el) {
        InfPay res = new InfPay();

        parseObject(res, el);

        return res;
    }

    private BankPay parseBankPay(Element el) {
        BankPay res = new BankPay();

        parseObject(res, el);

        return res;
    }

    private InfRcp parseInfRcp(Element el) {
        InfRcp res = new InfRcp();

        parseObject(res, el);

        return res;
    }

    private BankRcp parseBankRcp(Element el) {
        BankRcp res = new BankRcp();

        parseObject(res, el);

        return res;
    }

    private Doc parseDoc(Element el) {
        Doc res = new Doc();

        NodeList children = el.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {

            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) children.item(i);

                if (child.getTagName().equals("Inf_PAY")) {
                    res.setInf_PAY(parseInfPay(child));
                } else if (child.getTagName().equals("Bank_PAY")) {
                    res.setBank_PAY(parseBankPay(child));
                } else if (child.getTagName().equals("Inf_RCP")) {
                    res.setInf_RCP(parseInfRcp(child));
                } else if (child.getTagName().equals("Bank_RCP")) {
                    res.setBank_RCP(parseBankRcp(child));
                } else {
                    try {
                        checkFieldAndSet(res, child);
                    } catch(FieldMapException ex) {
                        logger.error(ex.toString());
                    }
                }
            }
        }

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
    public PayDocs parse(Document doc) {
        PayDocs paydocs = new PayDocs();
        Element root = doc.getDocumentElement();

        NodeList rootChildren = root.getChildNodes();

        for (int i = 0; i < rootChildren.getLength(); i++) {

            if (rootChildren.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) rootChildren.item(i);

                if (child.getTagName().equals("Docs"))
                    paydocs.setDocs(parseDocs(child));

                else {
                    try {
                        checkFieldAndSet(paydocs, child);
                    } catch (FieldMapException ex) {
                        logger.error(ex.toString());
                    }
                }
            }
        }

        return paydocs;

    }

    @Override
    public boolean applied(Document doc) {
        return doc.getDocumentElement().getTagName().equals(PAYDOCS_TAG);
    }
}
