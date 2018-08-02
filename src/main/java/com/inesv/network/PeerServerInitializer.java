package com.inesv.network;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Wu Created by SKINK on 2018/7/31.
 */
public class PeerServerInitializer extends ChannelInitializer<NioSocketChannel> {
  private static Logger logger = LoggerFactory.getLogger(PeerServerInitializer.class);

  @Override
  protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
    logger.info("peer入口");
    ChannelPipeline pipeline = nioSocketChannel.pipeline();
    pipeline.addLast("PeerServerHandler",new PeerServerHandler());
  }
}
