package com.litongjava.aio;

public class ServerConfig {
  private static ServerConfig me = new ServerConfig();

  public static ServerConfig me() {
    return me;
  }

  public ByteBufferHandler byteBufferHandler;

  public ByteBufferHandler getByteBufferHandler() {
    return byteBufferHandler;
  }

  public void setByteBufferHandler(ByteBufferHandler byteBufferHandler) {
    this.byteBufferHandler = byteBufferHandler;
  }
}
