package com.inesv;

import com.inesv.network.PeerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SuddenAttack Server
 *
 * @author SKINK
 */
@SpringBootApplication
public class ServerBootApp {

  public static void main(String[] args) {
    SpringApplication.run(ServerBootApp.class, args);
    PeerServer.init();
  }


}
