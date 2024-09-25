package com.litongjava.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;

public class AioHttpServerJava8 {

  public static void main(String[] args) {

    ServerConfig.me().setByteBufferHandler(new DefaultByteBufferHandler());
    try {
      // 创建异步服务器通道并绑定到端口8080
      AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open();
      serverChannel.bind(new InetSocketAddress(8080));

      System.out.println("AIO HTTP Server started on port 8080...");

      AcceptCompletionHandler acceptCompletionHandler = new AcceptCompletionHandler(serverChannel);

      serverChannel.accept(null, acceptCompletionHandler);

      // 防止主线程退出
      Thread.currentThread().join();

    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
    }
  }

}
