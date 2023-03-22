package com.litongjava.watcher.demo;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

/**
 * @author create by ping-e-lee on 2021年6月25日 下午3:47:50
 * @version 1.0
 * @desc
 */
public class Demo03 {
  private static WatchKey watchKey;
  private static boolean running = true;

  public static void main(String[] args) {
    String dir = "E:\\dev_workspace\\java\\java-study\\java-ee-spring-boot-study\\java-ee-spring-boot-2.1.6-study\\java-ee-spring-boot-2.1.6-hello\\target\\classes";
    List<Path> pathList = PathUtils.getPathList(new String[]{dir});

    WatchService watcher = null;
    try {
      watcher = FileSystems.getDefault().newWatchService();
    } catch (IOException e2) {
      e2.printStackTrace();
    }
    try {
      for (Path path : pathList) {
        path.register(watcher,
          // StandardWatchEventKinds.ENTRY_DELETE,
          StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE);
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    while (running) {
      try {
        // watchKey = watcher.poll(watchingInterval, TimeUnit.MILLISECONDS); //
        // watcher.take(); 阻塞等待
        // 比较两种方式的灵敏性，或许 take() 方法更好，起码资源占用少，测试 windows 机器上的响应
        watchKey = watcher.take();
        if (watchKey == null) {
          // System.out.println(System.currentTimeMillis() / 1000);
          continue;
        }
      } catch (Throwable e) { // 控制台 ctrl + c 退出 JVM 时也将抛出异常
        running = false;
        if (e instanceof InterruptedException) { // 另一线程调用 hotSwapWatcher.interrupt() 抛此异常
          Thread.currentThread().interrupt(); // Restore the interrupted status
        }
        break;
      }

      List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
      for (WatchEvent<?> event : watchEvents) {
        WatchEvent.Kind<?> kind = event.kind();
        String fileName = event.context().toString();
        System.out.println(kind+","+fileName);
      }
      resetWatchKey();
    }

    try {
      watcher.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private static void resetWatchKey() {
    if (watchKey != null) {
      watchKey.reset();
      watchKey = null;
    }
  }
}

