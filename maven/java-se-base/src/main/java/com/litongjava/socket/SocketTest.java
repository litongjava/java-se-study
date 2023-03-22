package com.litongjava.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author litong
 * @date 2018年11月3日_下午8:02:20 
 * @version 1.0 
 */
public class SocketTest {
  public static void main(String[] args) throws UnknownHostException, IOException {
    Socket socket = new Socket("127.0.0.1",9999);
    System.out.println("socket 连接建立成功");
  }
}
