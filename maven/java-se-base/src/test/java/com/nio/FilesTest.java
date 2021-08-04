package com.nio;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

/**
 * @author Administrator
 * @date 2019年1月4日_下午6:52:48 
 * @version 1.0 
 */
public class FilesTest {

  @Test
  public void test() {
    fail("Not yet implemented");
  }

  @Test
  public void readFile() {
    Path path = Paths.get("c:", "InstallConfig.ini");
    List<String> readAllLines = null;
    try {
      readAllLines = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    for (String string : readAllLines) {
      System.out.println(string);
    }
  }

  @Test
  public void readFile1() {
    Path path = Paths.get("D:\\logs\\sha1.txt");
    List<String> readAllLines = null;
    try {
      readAllLines = Files.readAllLines(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    StringBuffer sb = new StringBuffer();
    for (String s : readAllLines) {
      if (s.equals("\r\n") || s.equals("\n") || s.equals("")) {
        continue;
      }
      sb.append(s);
    }
    System.out.println(sb);
  }
}
