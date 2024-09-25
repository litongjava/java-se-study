package com.litongjava.aio.boot.utils;

import java.nio.charset.StandardCharsets;

public class RespnseUtils {

  public static String toResponse(int statusCode, String contentType, String body) {
    String statusMessage;
    switch (statusCode) {
    case 200:
      statusMessage = "OK";
      break;
    case 404:
      statusMessage = "Not Found";
      break;
    case 500:
      statusMessage = "Internal Server Error";
      break;
    default:
      statusMessage = "Unknown";
    }

    String response;
    String string = "HTTP/1.1 " + statusCode + " " + statusMessage + "\r\n" + "Content-Type: " + contentType + "\r\n";

    if (body != null) {
      byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
      response = string + "Content-Length: " + bytes.length + "\r\n" + "\r\n" + body;
    } else {
      response = string + "Content-Length: 0" + "\r\n" + "\r\n";
    }
    return response;
  }

}
