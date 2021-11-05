package com.udalny.xml.dom;

import com.udalny.documents.paydocs.*;
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
public class XMLDomParserPayDocs
        extends XMLDomParser
        implements XMLParser<PayDocs> {

    static final String PAYDOCS_TAG = "Inf_Pay_Doc";
    static final String UNKNOWN_TAG_WARNING = "Unknown tag found while parsing: {}";
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public XMLDomParserPayDocs() {
        super();
    }

    private InfPay parseInfPay(Element el) {
        InfPay res = new InfPay();

        NodeList children = el.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {

            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) children.item(i);

                switch (child.getTagName()) {
                    case "INN_PAY":
                        res.setInnPay(getTextValue(child));
                        break;
                    case "KPP_PAY":
                        res.setKppPay(getTextValue(child));
                        break;
                    case "CName_PAY":
                        res.setCnamePay(getTextValue(child));
                        break;
                    default:
                        logger.info(UNKNOWN_TAG_WARNING, child.getTagName());
                        break;
                }
            }
        }

        return res;
    }

    private BankPay parseBankPay(Element el) {
        BankPay res = new BankPay();

        NodeList children = el.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {

            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) children.item(i);

                switch (child.getTagName()) {
                    case "BS_PAY":
                        res.setBsPay(getTextValue(child));
                        break;
                    case "BIC_PAY":
                        res.setBicPay(getTextValue(child));
                        break;
                    case "BS_KS_PAY":
                        res.setBsKsPay(getTextValue(child));
                        break;
                    default:
                        logger.info(UNKNOWN_TAG_WARNING, child.getTagName());
                        break;
                }
            }
        }

        return res;
    }

    private InfRcp parseInfRcp(Element el) {
        InfRcp res = new InfRcp();

        NodeList children = el.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {

            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) children.item(i);

                switch (child.getTagName()) {
                    case "INN_PAY":
                        res.setInnPay(getTextValue(child));
                        break;
                    case "KPP_PAY":
                        res.setKppPay(getTextValue(child));
                        break;
                    case "CName_PAY":
                        res.setCnamePay(getTextValue(child));
                        break;
                    default:
                        logger.info(UNKNOWN_TAG_WARNING, child.getTagName());
                        break;
                }
            }
        }

        return res;
    }

    private BankRcp parseBankRcp(Element el) {
        BankRcp res = new BankRcp();

        NodeList children = el.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {

            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) children.item(i);

                switch (child.getTagName()) {
                    case "BS_PAY":
                        res.setBsPay(getTextValue(child));
                        break;
                    case "BIC_PAY":
                        res.setBicPay(getTextValue(child));
                        break;
                    case "BS_KS_PAY":
                        res.setBsKsPay(getTextValue(child));
                        break;
                    default:
                        logger.info(UNKNOWN_TAG_WARNING, child.getTagName());
                        break;
                }
            }
        }

        return res;
    }

    private Doc parseDoc(Element el) {
        Doc res = new Doc();

        NodeList children = el.getChildNodes();

        for (int i = 0; i < children.getLength(); i++) {

            if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element child = (Element) children.item(i);

                try {
                    switch (child.getTagName()) {
                        case "Num":
                            res.setNum(Integer.parseInt(getTextValue(child)));
                            break;
                        case "Date":
                            res.setDate(dateFormatter.parse(getTextValue(child)));
                            break;
                        case "ID":
                            res.setId(new BigInteger(getTextValue(child)));
                            break;
                        case "Nom_PP":
                            res.setNomPp(Integer.parseInt(getTextValue(child)));
                            break;
                        case "Date_PP":
                            res.setDatePp(dateFormatter.parse(getTextValue(child)));
                            break;
                        case "Sum_PP":
                            res.setSumPp(new BigDecimal(getTextValue(child)));
                            break;
                        case "Vid_Pay":
                            res.setVidPay(child.getAttribute("value"));
                            break;
                        case "Date_PP_IN":
                            res.setDatePpIn(dateFormatter.parse(getTextValue(child)));
                            break;
                        case "Date_PP_OUT":
                            res.setDatePpOut(dateFormatter.parse(getTextValue(child)));
                            break;
                        case "VID_Oper":
                            res.setVidOper(getTextValue(child));
                            break;
                        case "Purpose_ID":
                            res.setPurpose(getTextValue(child));
                            break;
                        case "Order_PAY":
                            res.setOrderPay(getTextValue(child));
                            break;
                        case "UIN":
                            res.setUin(getTextValue(child));
                            break;
                        case "Purpose":
                            res.setPurpose(getTextValue(child));
                            break;
                        case "Type_Pl":
                            res.setTypePl(getTextValue(child));
                            break;
                        case "Date_IN_TOFK":
                            res.setDateInTofk(dateFormatter.parse(getTextValue(child)));
                            break;
                        case "GUID":
                            res.setGuid(getTextValue(child));
                            break;
                        case "Inf_PAY":
                            res.setInfPay(parseInfPay(child));
                            break;
                        case "Bank_PAY":
                            res.setBankPay(parseBankPay(child));
                            break;
                        case "Inf_RCP":
                            res.setInfRcp(parseInfRcp(child));
                            break;
                        case "Bank_RCP":
                            res.setBankRcp(parseBankRcp(child));
                            break;
                        default:
                            logger.info(UNKNOWN_TAG_WARNING, child.getTagName());
                            break;
                    }
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
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
                    logger.info(UNKNOWN_TAG_WARNING,
                            docElement.getTagName());
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

                try {
                    switch (child.getTagName()) {
                        case "GUID_Doc":
                            paydocs.setGuidDoc(getTextValue(child));
                            break;
                        case "Date":
                            paydocs.setDate(dateFormatter.parse(getTextValue(child)));
                            break;
                        case "Scrc":
                            paydocs.setScrc(child.getAttribute("value"));
                            break;
                        case "Vid_Otch":
                            paydocs.setVidOtch(child.getAttribute("value"));
                            break;
                        case "Kol_Doc":
                            paydocs.setKolDoc(Integer.parseInt(getTextValue(child)));
                            break;
                        case "Docs":
                            paydocs.setDocs(parseDocs(child));
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

        return paydocs;

    }

    @Override
    public boolean applied(Document doc) {
        return doc.getDocumentElement().getTagName().equals(PAYDOCS_TAG);
    }
}
