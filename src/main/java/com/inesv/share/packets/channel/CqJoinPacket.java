package com.inesv.share.packets.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class CqJoinPacket extends ChannelPacket {
    private Integer snCode = CHANNEL_CODE + 2;
    private char channelIndex;

    public CqJoinPacket(int channelIndex) {
        this.channelIndex = (char) channelIndex;
    }

    @Override
    public byte[] getPacketBytes() {
        ByteBuf byteBuf = Unpooled.buffer(4);
        byteBuf.writeChar(snCode)
                .writeChar(channelIndex);
        return byteBuf.array();
    }
}
