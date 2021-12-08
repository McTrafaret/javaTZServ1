package com.udalny.documents.packet.creator;

import com.udalny.documents.file.File;
import com.udalny.documents.file.FileType;
import com.udalny.documents.packet.Packet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportPayDocsPacketCreator
        implements PacketCreator {

    @Override
    public Packet createPacket(List<File> from) {
        Packet packet = new Packet();
        for (File f : from) {
            if(f.getType() == FileType.REPORT) {
                packet.setMainDocument(f);
            }
            else
                packet.addDocument(f);
        }
        return packet;
    }

    @Override
    public boolean probe(List<File> from) {
        for (File f : from) {
            if(f.getType() == FileType.REPORT) {
                return true;
            }
        }
        return false;
    }
}
