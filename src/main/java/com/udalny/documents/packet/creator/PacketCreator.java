package com.udalny.documents.packet.creator;

import com.udalny.documents.file.File;
import com.udalny.documents.packet.Packet;

import java.util.List;

public interface PacketCreator {

    Packet createPacket(List<File> from);

    boolean probe(List<File> from);

}
