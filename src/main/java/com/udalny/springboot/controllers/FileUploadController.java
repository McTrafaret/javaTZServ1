package com.udalny.springboot.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.udalny.documents.ZipHandler;
import com.udalny.documents.file.File;
import com.udalny.documents.file.FileTypeSetter;
import com.udalny.documents.packet.Packet;
import com.udalny.documents.packet.creator.PacketCreator;
import com.udalny.documents.packet.handler.PacketHandler;
import com.udalny.upload.Uploader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class FileUploadController {

    private static Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();
    private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @Autowired
    private FileTypeSetter fileTypeSetter;

    @Autowired
    private PacketCreator<List<File>> packetCreator;

    @Autowired
    private List<PacketHandler> handlers;

    @Autowired
    private Uploader<String> uploader;


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
                                    produces = MediaType.APPLICATION_JSON_VALUE)
    public String fileUpload(@RequestParam("file") MultipartFile file)
            throws IOException {

        List<File> files = ZipHandler.createListOfFiles(file.getInputStream());
        fileTypeSetter.setAll(files);
        Packet packet = packetCreator.createPacket(files);
        String res = null;
        for (PacketHandler handler : handlers) {
            if (handler.probe(packet)) {
                res = gson.toJson(handler.handle(packet));
            }
        }
//        uploader.upload(res);
        return res;

    }

}