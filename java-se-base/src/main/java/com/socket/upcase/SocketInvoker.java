package com.socket.upcase;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author litong
 * @date 2018年8月9日_下午10:35:11 
 * @version 1.0
 * 接收socket服务端发送过来的数据
 */
public class SocketInvoker {
  public static void main(String[] args) throws Exception {
    System.out.println("this is client");
    Scanner input = new Scanner(System.in);
    // 1:创建一个基于TCP协议的socket服务,在建立对象时,要指定连接服务器和端口号
    Socket s = new Socket("127.0.0.1", 9999);
    System.out.println("和服务端连接建立成功");
    // 2:通过建立的Socket对象获取Socket中的输出流,的调用getOutStream方法
    System.out.println("请输入要转化的字母,或者单词!");
    while (true) {
      // 每次发送数据前都需要getOutputStream();
      OutputStream out = s.getOutputStream();
      // 如果输入end,发送end,并关闭socket
      String word = input.next();
      out.write(word.getBytes());
      System.out.println("发送到服务端的数据是:" + word);
      if (word.equals("end")) {
        input.close();
        s.close();
      } else {
        // 4: 通过建立的Socket对象获取Socket中的输入流,输入流会接受来自服务器端数据
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        // 5: 获取输入字节流的数据,注意此方法是堵塞的,如果没有获取数据会一直等待
        int len = in.read(buf);
        String str = new String(buf, 0, len);
        System.out.println("服务返回来的结果如下:");
        System.out.println(str);
      }
    }
  }
}