package com.inesv.network;



import io.netty.channel.ChannelHandlerContext;

import io.netty.channel.SimpleChannelInboundHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wu Created by SKINK on 2018/7/31.
 */
public class PeerServerHandlerV2 extends SimpleChannelInboundHandler<String> {
  private static Logger logger = LoggerFactory.getLogger(PeerServerHandlerV2.class);

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    logger.info("V2通道激活");
  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    logger.error(cause.getMessage());
    ctx.close();
  }

  @Override
  protected void channelRead0(ChannelHandlerContext channelHandlerContext, String msg)
      throws Exception {
    System.out.println("aa:"+msg);

  }


}
