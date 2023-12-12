package com.litongjava.server.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
  public static void main(String[] args) throws Exception {
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.socket().bind(new InetSocketAddress(8080));
    serverSocketChannel.configureBlocking(false);

    Selector selector = Selector.open();
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    while (true) {
      //等待新的事件
      selector.select();
      Set<SelectionKey> selectedKeys = selector.selectedKeys();
      Iterator<SelectionKey> iterator = selectedKeys.iterator();
      //新的事件接入
      while (iterator.hasNext()) {
        SelectionKey key = iterator.next();
        if (key.isAcceptable()) {
          // handle accept
          // 获取与SelectionKey关联的ServerSocketChannel
          ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();

          // 接受客户端的连接请求，并创建SocketChannel
          SocketChannel clientChannel = serverChannel.accept();

          // 将新的SocketChannel设置为非阻塞模式
          clientChannel.configureBlocking(false);

          // 将新的SocketChannel注册到Selector，监听读操作
          clientChannel.register(selector, SelectionKey.OP_READ);
        }
        if (key.isReadable()) {
          // handle read
          // 获取与SelectionKey关联的SocketChannel
          SocketChannel clientChannel = (SocketChannel) key.channel();

          // 创建一个Buffer，用于读取数据
          ByteBuffer buffer = ByteBuffer.allocate(1024);

          // 从SocketChannel读取数据到Buffer
          int bytesRead = clientChannel.read(buffer);

          if (bytesRead > 0) {
            // 数据读取成功，处理数据
            buffer.flip(); // 切换Buffer为读模式
            while (buffer.hasRemaining()) {
              System.out.print((char) buffer.get()); // 打印数据
            }
              System.out.println();
            buffer.clear(); // 清空Buffer

            // 假设我们要发送的字符串
            String response = "Hello, client!";
            ByteBuffer sendBuffer = ByteBuffer.allocate(1024);

            // 将数据写入到ByteBuffer
            sendBuffer.clear(); // 清空buffer并准备写入
            sendBuffer.put(response.getBytes());
            sendBuffer.flip(); // 切换为读模式
            // 将数据从ByteBuffer写入到SocketChannel
            while (sendBuffer.hasRemaining()) {
              clientChannel.write(sendBuffer);
            }
          } else if (bytesRead == -1) {
            // 客户端关闭了连接
            clientChannel.close();
          }
        }
        iterator.remove();
      }
    }
  }
}