package com.udalny.documents.packet;

import com.udalny.documents.file.File;
import com.udalny.documents.file.FileType;

import java.util.List;

public class PacketCreator {

    public static Packet createPacket(List<File> files) {

        Packet packet = new Packet();

        for (File f : files) {
            if (f.getType() == FileType.REPORT) {
                packet.setMainDocument(f);
            }
            else {
                packet.addDocument(f);
            }
        }

        return packet;
    }
}
