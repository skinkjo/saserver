package com.inesv.share.packets;

import com.inesv.share.Packet;

/**
 * @author Wu Created by SKINK on 2018/8/3.
 */
public class LoginPacket {
  private static Integer LOGIN_CODE = 100;
  public static class SALoginPacket extends Packet{
    //private byte HEAD = 12;
    //private Integer SN_CODE = LOGIN_CODE + 1;
    //private byte[] metaData = new byte[8];


    @Override
    public byte[] getPacketBytes() {
      return new byte[0];
    }
  }
}
