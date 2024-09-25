package com.litongjava.aio.boot.handler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class WriteCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

  private AsynchronousSocketChannel clientChannel;
  public WriteCompletionHandler(AsynchronousSocketChannel clientChannel) {
    this.clientChannel=clientChannel;
  }

  @Override
  public void completed(Integer result, ByteBuffer buffer) {
    try {
      clientChannel.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void failed(Throwable exc, ByteBuffer buffer) {
    try {
      clientChannel.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    exc.printStackTrace();
  }

}
