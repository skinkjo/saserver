package com.inesv.configure;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author Wu Created by SKINK on 2018/7/31.
 */
@Configuration
@EnableAsync
public class PoolConf {

  @Bean
  public Executor peerPool(){
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(5);
    executor.setQueueCapacity(5);
    executor.setKeepAliveSeconds(5);
    executor.setThreadNamePrefix("ServerPool-");
    // rejection-policy：当pool已经达到max size的时候，如何处理新任务
    // CALLER_RUNS：不在新线程中执行任务，而是由调用者所在的线程来执行
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.initialize();
    return executor;
  }

}
