package com.inesv.share;

public interface PacketConstant {
    interface PredefineCommand{
        int Ping = 0;
        int PingAck = 1;
        int Ack = 2;
        int Assemble = 3;
    }
    interface PredefineLength{
        int BasePacketSize = 256;
        int AssembleSize = 200;
        int GetQuerySize = 32767;
    }
}
