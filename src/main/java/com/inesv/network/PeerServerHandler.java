package com.inesv.network;

import com.inesv.configure.SessionGate;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wu Created by SKINK on 2018/7/31.
 */
public class PeerServerHandler extends ChannelInboundHandlerAdapter {
  private static Logger logger = LoggerFactory.getLogger(PeerServerHandler.class);

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    logger.info("通道激活");
    SessionGate.getInstance().setServer(ctx);
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    System.out.println("========CIN========");
    ByteBuf in = (ByteBuf) msg;
    ByteBuf copy = in.copy();
    List<Byte> bytes = new ArrayList<>();
    try{
      while (copy.isReadable()){
        byte s = copy.readByte();
        bytes.add(s);
        System.out.print((char) s);
      }
      System.out.println("");
      System.out.println("封包大小:"+bytes.size());
      System.out.println(bytes);
      System.out.println("========END========");

      byte[] loginPack = new byte[]{12, 0, 101, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 16};
      byte[] channelPack = new byte[]{-98, 0, 106, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 50, 124, -76, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 12, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 48, 56, 49, 53, 0, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, -51, 0, 20, 1, 6, 49, 53, 95, 68, 66, 0, 49, 56, 48, 56, 48, 50, 48, 48, 48, 48, 48, 54, 32, 32, 32, 32, 0, 0, 0, 16, 16, 6, 0, -56, 0, 3, 0, 16, 16, 10, 0, -55, 0, 0, 0, -128, 0, 0, 0, 16, 16, 10, 0, -55, 0, 1, 0, -128, 0, 0, 0, 16, 16, 10, 0, -55, 0, 2, 0, -128, 0, 0, 0, 16, 16, 46, 0, 109, 0, 48, 124, -48, -95, -47, -89, -55, -6, 124, 48, 13, 49, 124, -42, -48, -47, -89, -55, -6, 124, 51, 48, 48, 48, 13, 50, 124, -76, -13, -47, -89, -55, -6, 124, 49, 48, 48, 48, 48, 13, 0, 0, 16, 16};
      ByteBuf bb = Unpooled.wrappedBuffer(loginPack);
      ctx.writeAndFlush(bb);
      //bb = Unpooled.wrappedBuffer(channelPack);
      //ctx.writeAndFlush(bb);
      //SessionGate.getInstance().getClient().writeAndFlush(msg);
    }finally {
      //ReferenceCountUtil.safeRelease(in);
    }

  }

  @Override
  public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
    logger.error(cause.getMessage());
    ctx.close();
  }
}
