package com.udalny.documents.packet.creator;

import com.udalny.documents.file.File;
import com.udalny.documents.file.FileType;
import com.udalny.documents.packet.Packet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileListPacketCreator
        implements PacketCreator<List<File>> {

    @Override
    public Packet createPacket(List<File> files) {

        Packet packet = new Packet();

        for (File f : files) {
            if (f.getType() == FileType.REPORT) {
                packet.setMainDocument(f);
            } else {
                packet.addDocument(f);
            }
        }

        return packet;
    }
}
