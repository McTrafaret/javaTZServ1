package com.udalny.springboot;

import com.udalny.documents.SummaryDocument;
import com.udalny.documents.SummaryDocumentFactory;
import com.udalny.documents.ZipHandler;
import com.udalny.exceptions.InvalidZipContentsException;
import com.udalny.exceptions.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@RestController
public class FileUploadController {

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<SummaryDocument> fileUpload(@RequestParam("file") MultipartFile file)
            throws IOException {

        String filename = "/tmp/upload" + file.getOriginalFilename();
        File convertFile = new File(filename);
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();

        ZipHandler zipHandler = new ZipHandler(filename);

        try {
            return SummaryDocumentFactory.createListOfSummaryDocuments(zipHandler.getDocuments());
        } catch (ParseException ex) {
            System.err.println(ex);
        } catch (InvalidZipContentsException ex) {
            System.err.println(ex);
        }

        return null;

    }

}