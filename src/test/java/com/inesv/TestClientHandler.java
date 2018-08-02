package com.inesv;

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
 * @author Wu Created by SKINK on 2018/8/2.
 */
public class TestClientHandler  extends ChannelInboundHandlerAdapter {

  private static Logger logger = LoggerFactory.getLogger(TestClientHandler.class);


  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    logger.info("通道激活");
    byte[] req = new byte[]{-19, 0, 100, 0, 49, 50, 55, 46, 48, 46, 48, 46, 49, 0, 0, 0, 0, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 99, 112, 117, 61, 40, 71, 101, 110, 117, 105, 110, 101, 73, 110, 116, 101, 108, 41, 32, 85, 110, 107, 110, 111, 119, 110, 32, 32, 32, 32, 40, 51, 46, 57, 52, 71, 104, 122, 41, 124, 111, 115, 61, 87, 105, 110, 100, 111, 119, 115, 32, 88, 80, 32, 83, 101, 114, 118, 105, 99, 101, 32, 80, 97, 99, 107, 32, 49, 124, 114, 97, 109, 61, 52, 48, 57, 53, 124, 103, 114, 97, 112, 104, 105, 99, 61, 64, 111, 101, 109, 51, 50, 46, 105, 110, 102, 44, 37, 110, 118, 105, 100, 105, 97, 95, 100, 101, 118, 46, 49, 98, 56, 49, 37, 59, 78, 86, 73, 68, 73, 65, 32, 71, 101, 70, 111, 114, 99, 101, 32, 71, 84, 88, 32, 49, 48, 55, 48, 32, 32, 68, 114, 105, 118, 101, 114, 86, 101, 114, 58, 50, 50, 46, 50, 49, 46, 49, 51, 46, 56, 53, 54, 57, 32, 86, 105, 100, 77, 101, 109, 58, 32, 51, 54, 56, 57, 124, 115, 111, 117, 110, 100, 61, 110, 111, 110, 101, 124, 100, 105, 114, 101, 99, 116, 120, 61, 57, 46, 48, 48, 124, 0, 0, 16, 16};
    ByteBuf bb = Unpooled.wrappedBuffer(req);
    ctx.writeAndFlush(bb);
    SessionGate.getInstance().setClient(ctx);
  }

  @Override
  public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
    System.out.println("========OUT========");
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
      //SessionGate.getInstance().getServer().writeAndFlush(msg);
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
