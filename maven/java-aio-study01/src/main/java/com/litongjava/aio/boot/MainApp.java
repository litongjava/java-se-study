package com.litongjava.aio.boot;

import java.util.Map;

import com.litongjava.aio.boot.config.ServerConfig;
import com.litongjava.aio.boot.context.AioHttpServerJava8;
import com.litongjava.aio.boot.http.HttpRequestHandler;
import com.litongjava.aio.boot.http.HttpRequestRouter;
import com.litongjava.aio.boot.utils.RequestUtils;
import com.litongjava.aio.boot.utils.ResponseUtils;

public class MainApp {

  public static void main(String[] args) {
    HttpRequestRouter r = ServerConfig.me().getHttpRequestRouter();
    r.add("/", new HttpRequestHandler() {

      @Override
      public String handle(String request) throws Exception {
        Map<String, String> requestMap = RequestUtils.getRequestMap(request);
        String body = requestMap.get("ip");
        if (body == null) {
          body = "ok";
        }
        String response = ResponseUtils.toResponse(200, "text/plain;charset=utf-8", body);
        return response;
      }
    });
    AioHttpServerJava8.run();
  }

}
