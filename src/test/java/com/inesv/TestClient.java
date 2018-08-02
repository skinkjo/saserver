package com.inesv;

import com.inesv.network.PeerServer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Wu Created by SKINK on 2018/8/2.
 */
public class TestClient {

  private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
      new ArrayBlockingQueue<>(5));

  public static void main(String[] args) {

    executor.execute(TestClient::init);
    //executor.execute(PeerServer::init);


  }


  public static void init(){
    Bootstrap bootstrap = new Bootstrap();
    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    bootstrap.group(eventLoopGroup)
        .channel(NioSocketChannel.class)
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
        .option(ChannelOption.SO_KEEPALIVE, true)
        .handler(new TestClientIntializer());
    try {
      ChannelFuture channelFuture = bootstrap.connect("192.168.107.129", 12000).sync();
      channelFuture.channel().closeFuture().await();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      eventLoopGroup.shutdownGracefully();
    }
  }

}
