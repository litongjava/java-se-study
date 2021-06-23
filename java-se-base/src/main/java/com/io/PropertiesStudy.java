package com.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Properties;

/**
 * @author Administrator
 * @date 2019年1月10日_上午11:06:18 
 * @version 1.0 
 */
public class PropertiesStudy {
  public static void main(String[] args) {

  }

  void study2() {
    URL resource = this.getClass().getResource("/config.properties");
    File file = new File(resource.getFile());
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  void study1() {
    Properties properties = new Properties();
    properties.put("litong", "123");
    properties.put("liton1", "123");
    try {
      properties.store(new FileOutputStream("config-test.properties"), null);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    properties.put("liton1", "fjdk ");
    try {
      properties.store(new FileOutputStream("config-test.properties"), null);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
