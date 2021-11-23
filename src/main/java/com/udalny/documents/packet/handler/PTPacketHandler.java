package com.udalny.documents.packet.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.udalny.documents.PTDocument;
import com.udalny.documents.file.FileType;
import com.udalny.documents.packet.Packet;
import com.udalny.documents.packet.PacketResult;
import com.udalny.documents.packet.PacketType;
import com.udalny.exceptions.ParseException;
import com.udalny.xml.DocConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PTPacketHandler
        implements PacketHandler {

    private static Gson gson = new GsonBuilder().setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz").create();
    private static Logger logger = LoggerFactory.getLogger(PTPacketHandler.class);

    @Autowired
    DocConverter docConverter;

    @Override
    public boolean probe(Packet packet) {
        return packet.getMainDocument().getType() == FileType.PT;
    }

    @Override
    public PacketResult handle(Packet packet) {
        try {
            List<PTDocument> documents = docConverter.parse(packet.getMainDocument().getContents());
            return new PacketResult(PacketType.PT, gson.toJson(documents));
        } catch (ParseException ex) {
            logger.error(ex.getMessage(), ex);
            return null;
        }
    }
}
