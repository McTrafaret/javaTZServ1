package com.udalny.springboot;

import com.udalny.documents.*;
import com.udalny.exceptions.DocumentSetException;
import com.udalny.exceptions.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@RestController
public class FileUploadController {

    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<SummaryDocument> fileUpload(@RequestParam("file") MultipartFile file)
            throws IOException {

        try {

            DocumentSetBuilder<String> builder = new DocumentSetStringBuilder();
            for (String content : ZipHandler.createListOfFileContents(file.getInputStream())) {
                builder.addDocument(content);
            }

            DocumentSet docs = builder.createDocumentSet();

            if(!docs.getReport().getReport_type_flag().equals("Итоговая")) {
                return Collections.emptyList();
            }
            return SummaryDocumentFactory.createListOfSummaryDocuments(docs);

        } catch (ParseException | DocumentSetException ex) {
            logger.error(ex.toString());
            ex.printStackTrace();
        }

        return Collections.emptyList();


        //service, //autowired
//        ZipHandler zipHandler = new ZipHandler(filename);


    }

}