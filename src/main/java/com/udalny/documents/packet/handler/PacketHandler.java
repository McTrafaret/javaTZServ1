package com.udalny.documents.packet.handler;

import com.udalny.documents.packet.Packet;
import com.udalny.documents.packet.PacketResult;

public interface PacketHandler {
    boolean probe(Packet packet);
    PacketResult handle(Packet packet);
}
