package com.nio;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

/**
 * @author Administrator
 * @date 2019年1月4日_下午6:34:55 
 * @version 1.0 
 */
@Log4j
public class PathsTest {

  @Test
  public void test() {
    fail("Not yet implemented");
  }

  /**
   * 删除文件
   */
  @Test
  public void deleteFile() {
    Path path = Paths.get("f:/a.txt"); // 文件不存在
    try {
      Files.delete(path); // 删除一个不存在的文件
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 遍历目录,不包括文件
   */
  @Test
  public void foreachDir() {
    Path dir = Paths.get("d:", "Program Files");
    try {
      DirectoryStream<Path> d = Files.newDirectoryStream(dir);
      for(Path p:d) {
        System.out.println(p.getFileName());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  /**
   * 同目录下的文件
   */
  @Test
  public void getPaths() {
    String pathname="D:\\dev_mavenRepository\\com\\alibaba\\fastjson\\1.2.47\\fastjson-1.2.47.jar";
    Path path = Paths.get(pathname);
    log.info("path:"+path);
    Path absolutePath=path.toAbsolutePath();
    log.info("absolute path:"+absolutePath);
    
  }

}
