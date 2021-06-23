package com.socket.upcase;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by litong on 2018/11/3 0003.
 */
public class SocketProvider {
  public static void main(String[] args) throws IOException {
    System.out.println("this is server");
    ServerSocket ss = new ServerSocket(9999);
    System.out.println("服务端启动成功");
    Socket s = ss.accept();
    System.out.println("和客户端的连接建立成功");
    while (true) {
      // 获取客户端发送的数据流
      InputStream in = s.getInputStream();
      // 将ins中的数据转换成字符
      BufferedInputStream bufIn = new BufferedInputStream(in);
      StringBuffer strBuf = new StringBuffer();

      byte[] buf = new byte[1024];
      while (true) {

        // 进行阻塞,如果ins中没有数据,则阻塞进程
        int len = in.read(buf);
        String input = new String(buf, 0, len);
        System.out.println("接收到的数据是:" + input);
        // 如果接收到的是end,关闭socket
        if (input.equals("end")) {
          System.out.println("关闭socket");
          ss.close();
        } else {
          // 转换成大小,并发送
          OutputStream out = s.getOutputStream();
          String outputString = input.toUpperCase();
          out.write(outputString.getBytes());
          System.out.println("输出的字符串是:" + outputString);
        }

      }
    }
  }
}
