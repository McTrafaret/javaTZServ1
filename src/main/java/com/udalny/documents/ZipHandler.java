package com.udalny.documents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipHandler {

    //4. slf4j
    private static Logger logger = LoggerFactory.getLogger(ZipHandler.class);

    private ZipHandler() {
    }

    public static List<String> createListOfFileContents(InputStream in)
            throws IOException {

        ZipInputStream zipStream = new ZipInputStream(in);

        List<String> contentsList = new LinkedList<>();
        for (ZipEntry entry = zipStream.getNextEntry(); entry != null; entry = zipStream.getNextEntry()) {

            ByteArrayOutputStream res = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];

            int length = 0;
            do {
                res.write(buffer, 0, length);
                length = zipStream.read(buffer);
            } while (length != -1);

            contentsList.add(res.toString());

        }

        return contentsList;

    }


}
