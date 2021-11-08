package com.udalny.documents;

import com.udalny.documents.file.File;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Component
public class ZipHandler {

    private ZipHandler() {
    }

    public static List<File> createListOfFiles(InputStream in)
            throws IOException {

        ZipInputStream zipStream = new ZipInputStream(in);

        List<File> files = new ArrayList<>();
        for (ZipEntry entry = zipStream.getNextEntry(); entry != null; entry = zipStream.getNextEntry()) {

            ByteArrayOutputStream res = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];

            int length = 0;
            do {
                res.write(buffer, 0, length);
                length = zipStream.read(buffer);
            } while (length != -1);

            files.add(new File(entry.getName(), res.toString()));

        }

        return files;

    }

}
