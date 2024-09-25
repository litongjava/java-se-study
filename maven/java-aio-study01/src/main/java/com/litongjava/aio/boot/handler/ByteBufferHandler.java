package com.litongjava.aio.boot.handler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;

public interface ByteBufferHandler {

  public ByteBuffer handle(AsynchronousSocketChannel clientChannel, Integer result, ByteBuffer attachment);
}
