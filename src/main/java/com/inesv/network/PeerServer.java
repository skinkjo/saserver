package com.inesv.network;

import com.inesv.configure.GameConf;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author Wu Created by SKINK on 2018/7/31.
 */
@Component
public class PeerServer {

  private static Logger logger = LoggerFactory.getLogger(PeerServer.class);

  //@Async("peerPool")
  public static void init() {
    logger.info("=====SERVER INIT====");
    logger.info(">>>>>SERVER-PORT[{}]",GameConf.SA_SERVER_PORT+1);
    ServerBootstrap bootstrap = new ServerBootstrap();
    EventLoopGroup bossLoopGroup = new NioEventLoopGroup();
    EventLoopGroup childLoopGroup = new NioEventLoopGroup();
    bootstrap.group(bossLoopGroup, childLoopGroup)
        .channel(NioServerSocketChannel.class)
        .option(ChannelOption.SO_BACKLOG, 128)
        .childHandler(new PeerServerInitializer())
        .childOption(ChannelOption.SO_KEEPALIVE, true);
        //.childOption(ChannelOption.TCP_NODELAY, true);
    try {
      ChannelFuture channelFuture = bootstrap.bind(GameConf.SA_SERVER_PORT+1).sync();
      channelFuture.channel().closeFuture().await();
    } catch (Exception e) {
      e.printStackTrace();
      logger.error(e.getMessage());
    } finally {
      childLoopGroup.shutdownGracefully();
      bossLoopGroup.shutdownGracefully();
    }


  }

}
