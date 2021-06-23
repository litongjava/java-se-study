package com.commons.io;

import org.apache.commons.io.FilenameUtils;

/**
 * @author litong
 * @date 2018年12月7日_下午7:52:01 
 * @version 1.0 
 */
public class FilenameUtilsStudy {
  public static void main(String[] args) {
    String url = "http://www.baidu.com/log.png";
    String baseName = FilenameUtils.getBaseName(url);
    System.out.println(baseName);
    String extension = FilenameUtils.getExtension(url);
    System.out.println(extension);
    String name = FilenameUtils.getName(url);
    System.out.println(name);
  }
}
