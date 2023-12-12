package com.litongjava.server.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

public class AIOServer {
  public static void main(String[] args) throws Exception {
    AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open();
    serverSocketChannel.bind(new InetSocketAddress(8080));

    run(serverSocketChannel);

    // keep the server running
    Thread.currentThread().join();
  }

  private static void run(AsynchronousServerSocketChannel serverSocketChannel) {
    serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
      @Override
      public void completed(AsynchronousSocketChannel channel, Void attachment) {
        // handle completed connection
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
          @Override
          public void completed(Integer result, ByteBuffer attachment) {
            // 处理读取到的数据
            if (result > 0) {
              attachment.flip();
              // 读取数据后的处理，例如打印或者逻辑处理
              while (attachment.hasRemaining()) {
                System.out.print((char) attachment.get());
              }
              System.out.println();

              // 准备发送的数据
              String response = "Hello, client!";
              ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
              writeBuffer.put(response.getBytes());
              writeBuffer.flip();

              // 异步写入数据到客户端
              channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer buffer) {
                  // 写操作完成后的处理
                }

                @Override
                public void failed(Throwable exc, ByteBuffer buffer) {
                  // 写操作失败的处理
                  try {
                    channel.close();
                  } catch (IOException e) {
                    // 异常处理
                  }
                }
              });
            }
          }

          @Override
          public void failed(Throwable exc, ByteBuffer attachment) {
            // 读操作失败的处理
            try {
              channel.close();
            } catch (IOException e) {
              // 异常处理
            }
          }
        });

        serverSocketChannel.accept(null, this); // 接受下一个连接
      }

      @Override
      public void failed(Throwable exc, Void attachment) {
        // 连接失败的处理
      }
    });
  }
}