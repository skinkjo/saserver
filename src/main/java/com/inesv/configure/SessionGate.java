package com.inesv.configure;

import io.netty.channel.ChannelHandlerContext;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wu Created by SKINK on 2018/8/2.
 */
public class SessionGate {

  private static SessionGate ourInstance = new SessionGate();

  public static SessionGate getInstance() {
    return ourInstance;
  }

  private SessionGate() {
  }

  private static ConcurrentHashMap<String,ChannelHandlerContext> concurrentHashMap = new ConcurrentHashMap<>();

  public void setServer(ChannelHandlerContext server){
    concurrentHashMap.put("SERVER",server);
  }

  public void setClient(ChannelHandlerContext client){
    concurrentHashMap.put("CLIENT",client);
  }

  public ChannelHandlerContext getServer(){
    return concurrentHashMap.get("SERVER");
  }

  public ChannelHandlerContext getClient(){
    return concurrentHashMap.get("CLIENT");
  }



}
