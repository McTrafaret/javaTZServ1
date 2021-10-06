package com.udalny.documents;

import com.udalny.exceptions.InvalidZipContentsException;
import com.udalny.exceptions.ParseException;
import com.udalny.xml.jaxb.DocConverter;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipHandler {
    ZipFile zip;
    LinkedList<ZipEntry> entriesList;
    static Logger logger = Logger.getLogger(ZipHandler.class);

    private void leaveOnlyXMLInEntriesList(LinkedList<ZipEntry> list) {
        Iterator<ZipEntry> iter = list.iterator();
        Pattern pattern = Pattern.compile(".*\\.xml", Pattern.CASE_INSENSITIVE);
        iter.next();
        while (iter.hasNext()) {
            ZipEntry entry = iter.next();
            String filename = entry.getName();
            Matcher m = pattern.matcher(filename);
            if (!m.matches()) {
                iter.remove();
            }
        }
    }

    public ZipHandler(String filename)
            throws IOException {

        zip = new ZipFile(filename);

        entriesList = new LinkedList<>();
        Enumeration<? extends ZipEntry> e = zip.entries();
        while (e.hasMoreElements()) {
            ZipEntry entry = e.nextElement();
            entriesList.add(entry);
        }
    }

    public DocumentPair getDocuments()
            throws InvalidZipContentsException, ParseException, IOException {
        ServerDocument a;
        ServerDocument b;
        LinkedList<ZipEntry> temp = new LinkedList<>(entriesList);
        leaveOnlyXMLInEntriesList(temp);
        if (temp.size() != 2) {
            throw new InvalidZipContentsException();
        }

        a = DocConverter.getInstance().parse(zip.getInputStream(temp.get(0)));
        b = DocConverter.getInstance().parse(zip.getInputStream(temp.get(1)));

        return new DocumentPair(a, b);
    }
}
