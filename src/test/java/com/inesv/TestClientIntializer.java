package com.inesv;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wu Created by SKINK on 2018/7/31.
 */
public class TestClientIntializer extends ChannelInitializer<NioSocketChannel> {
  private static Logger logger = LoggerFactory.getLogger(TestClientIntializer.class);

  @Override
  protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
    logger.info("peer入口");
    ChannelPipeline pipeline = nioSocketChannel.pipeline();
    ByteBuf delimiter = Unpooled.copiedBuffer(new byte[]{16,16});
    pipeline.addLast(new DelimiterBasedFrameDecoder(1024,delimiter));
    pipeline.addLast("testClientHandler",new TestClientHandler());
  }
}
