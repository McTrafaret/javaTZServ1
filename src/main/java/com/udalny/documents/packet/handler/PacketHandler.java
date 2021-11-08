package com.udalny.documents.packet.handler;

import com.udalny.documents.packet.Packet;

public interface PacketHandler {
    boolean probe(Packet packet);
    String handle(Packet packet);
}
