package com.litongjava.aio.boot.http;

@FunctionalInterface
public interface HttpRequestHandler {
  String handle(String rquest) throws Exception;
}
