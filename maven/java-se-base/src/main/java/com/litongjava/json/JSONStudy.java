package com.litongjava.json;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 * @date 2019年1月12日_下午7:42:44 
 * @version 1.0 
 */
public class JSONStudy {
  public static void main(String[] args) throws IOException {
    JSONStudy study = new JSONStudy();
    study.study02();
  }

  /**
   * 写入json文件
   * @throws IOException
   */
  public void study01() throws IOException {
    List<User> userList = new ArrayList<>();
    userList.add(new User("user1", "pswd1"));
    FileWriter fileWriter = new FileWriter(new File("users.json"));
    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    JSON.writeJSONString(bufferedWriter, userList);
  }

  /**
   * 文件读入java-bean
   * @throws FileNotFoundException 
   */
  public void study02() throws FileNotFoundException {
    FileInputStream fileInputStream = new FileInputStream(new File("users.json"));
    BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
    try {
      Object parseObject = JSON.parseObject(bufferedInputStream, User.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * json字符串转List<bean>
   */
  public void study03() {
    String json = "[{\"pswd\":\"pswd1\",\"user\":\"user1\"}]";
    List<User> userList = JSON.parseArray(json, User.class);
    for (User user : userList) {
      System.out.println(user);
    }
  }

  /**
   * 读取文件中的json,转list<bean>
   */
  public <T> List<T> parseArray(Reader reader, Class<T> clazz) {
    List<T> list = new ArrayList<T>();
    BufferedReader bufferedReader = new BufferedReader(reader);
    char[] buffer=new char[1024*10];
    try {
      while((bufferedReader.read(buffer))>0) {
        
      }
    } catch (IOException e) {
      e.printStackTrace();
    }finally {
      IOUtils.closeQuietly(bufferedReader);
    }
    return list;
  }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
  private String user, pswd;
}
