package com.inesv;

import com.inesv.share.Packet;
import com.inesv.share.packets.LoginPacket.SALoginPacket;
import java.util.Arrays;


/**
 * @author Wu Created by SKINK on 2018/8/3.
 */
public class PacketsTest {

  public static void main(String[] args) {
    Short s = 100;
    System.out.println(s.byteValue());



    Packet saLoginPacket = new SALoginPacket();
    saLoginPacket.setMetaData(new byte[8]);
    System.out.println(Arrays.toString(saLoginPacket.getPacketBytes()));
    System.out.println(-54&0xFF);
    //System.out.println(Arrays.toString(serialize(saLoginPacket)));
  }



}
