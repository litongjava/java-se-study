package com.litongjava.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class DefaultByteBufferHandler implements ByteBufferHandler {

  @Override
  public ByteBuffer handle(AsynchronousSocketChannel clientChannel, Integer result, ByteBuffer attachment) {
    attachment.flip();
    String request = StandardCharsets.UTF_8.decode(attachment).toString();

    // 解析请求路径
    String requestPath = RequestUtils.getRequestPath(request);
    if ("/".equals(requestPath)) {
      String response = defaultHandler(request);
      // 构建HTTP响应
      writeHttpResponse(clientChannel, response);
      // 发送响应
      return null;
    }

    // 其他路径,返回404
    String response = RespnseUtils.toResponse(404, "text/plain", "404 Not Found");
    writeHttpResponse(clientChannel, response);

    return null;
  }

  private static void writeHttpResponse(AsynchronousSocketChannel clientChannel, String response) {
    ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes());
    WriteCompletionHandler writeCompletionHandler = new WriteCompletionHandler(clientChannel);
    clientChannel.write(responseBuffer, responseBuffer, writeCompletionHandler);
  }

  private String defaultHandler(String request) {
    // 解析请求，获取IP参数
    Map<String, String> requestMap = RequestUtils.getRequestMap(request);
    String body = requestMap.get("ip");
    if (body == null) {
      body = "ok";
    }
    String response = RespnseUtils.toResponse(200, "text/plain;charset=utf-8", body);
    return response;
  }

}
