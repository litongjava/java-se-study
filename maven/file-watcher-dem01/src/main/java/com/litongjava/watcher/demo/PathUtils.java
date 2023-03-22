package com.litongjava.watcher.demo;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class PathUtils {

  public static List<Path> getPathList(String[] classPathArray){
    System.out.println(Arrays.deepToString(classPathArray));
    Set<String> watchingDirSet = new HashSet<>();
    for (String classPath : classPathArray) {
      buildDirs(new File(classPath.trim()), watchingDirSet);
    }

    List<String> dirList = new ArrayList<String>(watchingDirSet);
    Collections.sort(dirList);

    List<Path> pathList = new ArrayList<Path>(dirList.size());
    System.out.println("观察的目录有:");
    for (String dir : dirList) {
      System.out.println(dir);
      pathList.add(Paths.get(dir));
    }
    System.out.println("pathList");
    for (Path path : pathList) {
      System.out.println(path.getFileName());
    }
    return pathList;
  }
  private static void buildDirs(File file, Set<String> watchingDirSet) {
    if (file.isDirectory()) {
      watchingDirSet.add(file.getPath());

      File[] fileList = file.listFiles();
      for (File f : fileList) {
        buildDirs(f, watchingDirSet);
      }
    }
  }
}
