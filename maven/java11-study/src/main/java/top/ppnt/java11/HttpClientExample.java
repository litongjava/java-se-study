package top.ppnt.java11;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientExample {
  public static void main(String[] args) {
    // 创建一个HTTP客户端实例
    HttpClient httpClient = HttpClient.newHttpClient();

    // 创建一个HTTP请求
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
      .build();

    // 发送HTTP请求并异步获取响应
    CompletableFuture<HttpResponse<String>> responseFuture = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

    // 处理异步响应
    responseFuture.thenApply(HttpResponse::body)
      .thenAccept(body -> {
        System.out.println("Response body:");
        System.out.println(body);
      })
      .join(); // 等待异步操作完成
  }
}