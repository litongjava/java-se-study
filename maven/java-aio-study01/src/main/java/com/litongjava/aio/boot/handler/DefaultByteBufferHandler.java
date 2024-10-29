package com.litongjava.aio.boot.handler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.StandardCharsets;

import com.litongjava.aio.boot.config.ServerConfig;
import com.litongjava.aio.boot.http.HttpRequestHandler;
import com.litongjava.aio.boot.http.HttpRequestRouter;
import com.litongjava.aio.boot.utils.RequestUtils;
import com.litongjava.aio.boot.utils.ResponseUtils;

public class DefaultByteBufferHandler implements ByteBufferHandler {

  @Override
  public ByteBuffer handle(AsynchronousSocketChannel clientChannel, Integer result, ByteBuffer attachment) {
    attachment.flip();
    String request = StandardCharsets.UTF_8.decode(attachment).toString();

    // 解析请求路径
    String requestPath = RequestUtils.getRequestPath(request);

    HttpRequestRouter httpRequestRouter = ServerConfig.me().getHttpRequestRouter();
    HttpRequestHandler handler = httpRequestRouter.find(requestPath);
    if (handler != null) {
      String response = null;
      try {
        response = handler.handle(request);
      } catch (Exception e) {
        response = ResponseUtils.toResponse(500, "text/plain", e.getMessage());
        e.printStackTrace();
      }
      if (request == null) {
        response = ResponseUtils.toResponse(404, "text/plain", "Null");
        writeHttpResponse(clientChannel, response);
      } else {
        writeHttpResponse(clientChannel, response);
      }

    }else {
      // 其他路径,返回404
      String response = ResponseUtils.toResponse(404, "text/plain", "404 Not Found");
      writeHttpResponse(clientChannel, response);
    }


    return null;
  }

  private static void writeHttpResponse(AsynchronousSocketChannel clientChannel, String response) {
    ByteBuffer responseBuffer = ByteBuffer.wrap(response.getBytes());
    WriteCompletionHandler writeCompletionHandler = new WriteCompletionHandler(clientChannel);
    clientChannel.write(responseBuffer, responseBuffer, writeCompletionHandler);
  }

}
