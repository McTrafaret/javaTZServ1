package com.udalny.documents.packet.creator;

import com.udalny.documents.packet.Packet;

public interface PacketCreator<T> {

    Packet createPacket(T from);

}
