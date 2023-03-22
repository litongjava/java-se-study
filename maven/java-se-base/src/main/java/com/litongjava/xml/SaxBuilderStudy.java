package com.litongjava.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Administrator
 * @date 2019年1月21日_下午9:26:14 
 * @version 1.0 
 */
public class SaxBuilderStudy {
  public static void main(String[] args) {
    SaxBuilderStudy study = new SaxBuilderStudy();
    study.study01();
  }

  /**
   * 
   */
  public void study01() {
    String xml = "<user><username>litong</username><password>password</password></user>";
    SAXBuilder saxBuilder = new SAXBuilder();
    ByteArrayInputStream inputStream = new ByteArrayInputStream(xml.getBytes());
    Document doucment = null;
    try {
      doucment = saxBuilder.build(inputStream);
    } catch (JDOMException | IOException e) {
      e.printStackTrace();
    }
    Element rootElement = doucment.getRootElement();
    System.out.println("robot element name:" + rootElement.getName());
    List<Element> children = rootElement.getChildren();
    System.out.println("children size:" + children.size());
    for(int i=0;i<children.size();i++) {
      
    }
    
  }
}
