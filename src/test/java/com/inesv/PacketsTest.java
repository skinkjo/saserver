package com.inesv;

import com.inesv.share.packets.channel.ChannelPacket;
import com.inesv.share.packets.channel.CqJoinPacket;

import java.util.Arrays;


/**
 * @author Wu Created by SKINK on 2018/8/3.
 */
public class PacketsTest {

  public static void main(String[] args) {
    System.out.println("=====");
    ChannelPacket channelPacket = new CqJoinPacket(1);
    System.out.println(Arrays.toString(channelPacket.getPacketBytes()));
    System.out.println(channelPacket.getPacketBytes().length);
    byte[] bb = new byte[]{16,16};
    System.out.println();
    //System.out.println(Arrays.toString(saLoginPacket.getPacketBytes()));
    //System.out.println(-54&0xFF);
    //System.out.println(Arrays.toString(serialize(saLoginPacket)));
  }



}
