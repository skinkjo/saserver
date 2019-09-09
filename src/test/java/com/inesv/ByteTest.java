package com.inesv;

import java.util.Arrays;

/**
 * @author Wu Created by SKINK on 2018/7/31.
 */
public class ByteTest {

  public static void main(String[] args) {
    Integer sCode = 237;
    System.out.println(sCode.byteValue());
    byte s = 16;
    Integer aa = s & 0xff;
    System.out.println(aa);
    //System.out.println(Arrays.toString("1".getBytes()));
  }

}
