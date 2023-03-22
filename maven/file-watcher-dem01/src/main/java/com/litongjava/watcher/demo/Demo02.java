package com.litongjava.watcher.demo;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author create by ping-e-lee on 2021年6月25日 下午3:57:34 
 * @version 1.0 
 * @desc
 */
public class Demo02 {
  public static void main(String[] args) {
    
    //String[] classPathArray = System.getProperty("java.class.path").split(File.pathSeparator);

    String dir = "E:\\dev_workspace\\java\\java-study\\java-ee-spring-boot-study\\java-ee-spring-boot-2.1.6-study\\java-ee-spring-boot-2.1.6-hello\\target\\classes";
    String[] classPathArray={dir};
    List<Path> pathList = PathUtils.getPathList(classPathArray);

  }

}
