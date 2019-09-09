package com.inesv.share;

public class PacketBuffer extends Packet{
    private char[] buffer = new char[PacketConstant.PredefineLength.BasePacketSize+2];
    private int bufferSize;
    private byte[] data;
    private int dataSize;
    private long handle;
    private long sendIndex;


    @Override
    public byte[] getPacketBytes() {

        return new byte[0];
    }
}
