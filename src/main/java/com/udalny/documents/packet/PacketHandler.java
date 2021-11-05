package com.udalny.documents.packet;

public interface PacketHandler {
    boolean probe(Packet packet);
    String handle(Packet packet);
}
