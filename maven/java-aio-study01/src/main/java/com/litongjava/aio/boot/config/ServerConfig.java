package com.litongjava.aio.boot.config;

import com.litongjava.aio.boot.handler.ByteBufferHandler;
import com.litongjava.aio.boot.handler.DefaultByteBufferHandler;
import com.litongjava.aio.boot.http.DefaultHttpReqeustRouter;
import com.litongjava.aio.boot.http.HttpRequestRouter;

public class ServerConfig {
  private static ServerConfig me = new ServerConfig();

  public static ServerConfig me() {
    return me;
  }

  private ByteBufferHandler byteBufferHandler = new DefaultByteBufferHandler();;
  private HttpRequestRouter httpRequestRouter = new DefaultHttpReqeustRouter();

  public HttpRequestRouter getHttpRequestRouter() {
    return httpRequestRouter;
  }

  public void setHttpRequestRouter(HttpRequestRouter httpRequestRouter) {
    this.httpRequestRouter = httpRequestRouter;
  }

  public ByteBufferHandler getByteBufferHandler() {
    return byteBufferHandler;
  }

  public void setByteBufferHandler(ByteBufferHandler byteBufferHandler) {
    this.byteBufferHandler = byteBufferHandler;
  }
}
