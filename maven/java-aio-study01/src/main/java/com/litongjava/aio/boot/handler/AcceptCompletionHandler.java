package com.litongjava.aio.boot.handler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, Void> {

  private AsynchronousServerSocketChannel serverChannel;

  public AcceptCompletionHandler(AsynchronousServerSocketChannel serverChannel) {
    this.serverChannel = serverChannel;
  }

  @Override
  public void completed(AsynchronousSocketChannel clientChannel, Void attachment) {
    // 再次调用 accept()，以继续接受新连接
    serverChannel.accept(null, this);

    if (clientChannel != null && clientChannel.isOpen()) {
      ByteBuffer buffer = ByteBuffer.allocate(4096);
      ReadCompletionHandler readCompletionHandler = new ReadCompletionHandler(clientChannel);
      clientChannel.read(buffer, buffer, readCompletionHandler);
    }

  }

  @Override
  public void failed(Throwable exc, Void attachment) {
    serverChannel.accept(null, this);
    exc.printStackTrace();
  }

}
