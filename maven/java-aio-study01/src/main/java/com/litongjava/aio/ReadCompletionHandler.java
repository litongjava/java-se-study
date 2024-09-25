package com.litongjava.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

  private AsynchronousSocketChannel clientChannel;

  public ReadCompletionHandler(AsynchronousSocketChannel clientChannel) {
    this.clientChannel = clientChannel;
  }

  @Override
  public void completed(Integer result, ByteBuffer attachment) {
    ServerConfig.me().getByteBufferHandler().handle(clientChannel, result, attachment);
  }

  @Override
  public void failed(Throwable exc, ByteBuffer attachment) {
    exc.printStackTrace();
    try {
      clientChannel.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
