package com.litongjava.study.se.maven;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author create by ping-e-lee on 2021年6月23日 下午11:10:48 
 * @version 1.0 
 * @desc
 */
public class ArtifactIdDemo {

  /**
   * 检查ArtifactId获取文件名是否一致
   * <artifactId>java-se-jsoup-demo1</artifactId>
   * @param args
   * @throws DocumentException 
   */
  public static void main(String[] args) throws DocumentException {
    String parentPath = "E:\\dev_workspace\\java\\java-study\\java-se-study";
    File mavenParentPathFile = new File(parentPath);
    File[] listFiles = mavenParentPathFile.listFiles();
    for (File file : listFiles) {
      if (file.isDirectory()) {
        String dirName = file.getName();
        if (!dirName.startsWith(".")) {
          validateArtifactId(file);
        }
      }
    }
  }

  /**
   * 验证artifaceId
   * @param file
   * @throws DocumentException 
   */
  private static void validateArtifactId(File file) throws DocumentException {
    String xmlPath = file.getAbsolutePath() + "/pom.xml";
    File xmlFile = new File(xmlPath);
    if (!xmlFile.exists()) {
      System.err.printf("%s not found \n", xmlFile.getAbsolutePath());
      return;
    }
    /**
     * 获取artifactId的值
     */
    SAXReader saxReader = new SAXReader();
    Document document = saxReader.read(xmlFile);
    Element rootElement = document.getRootElement();
    Element artifactIdElement = rootElement.element("artifactId");
    String text = artifactIdElement.getText();

    /**
     * 判断和文件名是否一致
     */
    String filename = file.getName();
    if (!filename.equals(text)) {
      System.out.printf("%s \t %s \n", filename, text);
      artifactIdElement.setText(filename);
    }
    // 保存文件
    Dom4jUtils.write(document, xmlPath);

  }
}
