package com.inesv.share;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Wu Created by SKINK on 2018/8/3.
 */
public abstract class Packet implements Serializable{

  private String command;
  private Integer length;

  private Integer snCode;
  private byte[] metaData;

  public Packet(String command, Integer snCode) {
    this.command = command;
    this.snCode = snCode;
  }

  public String getCommand() {
    return command;
  }

  public void setCommand(String command) {
    this.command = command;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
    this.length = length;
  }

  public byte[] getMetaData() {
    return metaData;
  }

  public void setMetaData(byte[] metaData) {
    setLength(4+metaData.length);
    this.metaData = metaData;
  }

  public byte[] getPacketBytes(){
    Integer packLeng = 4+metaData.length;
    byte[] bytes = new byte[4];
    bytes[0] = packLeng.byteValue();
    bytes[2] = snCode.byteValue();
    bytes = byteMerger(bytes,metaData);
    bytes = byteMerger(bytes,new byte[]{16,16});
    return bytes;
  }

  private static byte[] byteMerger(byte[] bt1, byte[] bt2){
    byte[] bt3 = new byte[bt1.length+bt2.length];
    System.arraycopy(bt1, 0, bt3, 0, bt1.length);
    System.arraycopy(bt2, 0, bt3, bt1.length, bt2.length);
    return bt3;
  }
}
