package com.udalny.documents.packet;

public class PacketResult {

    private final PacketType type;
    private final String data;

    public PacketResult(PacketType type, String data) {
        this.type = type;
        this.data = data;
    }

    public PacketType getType() {
        return type;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "PacketResult{" +
                "type=" + type +
                ", data='" + data + '\'' +
                '}';
    }
}
