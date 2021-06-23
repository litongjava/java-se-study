package com.jxab;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author Administrator
 * @date 2019年1月23日_下午4:58:22 
 * @version 1.0 
 */
public class JxabStudy {
  public static void main(String args[]) {
    // People p = new People();
    People p = new People();
    convertToXml(p, "utf-8");
    String xml = "<?xml version='1.0' encoding='utf-8' standalone='yes'?>" + "<employee>" + "<id>002</id>"
        + "<name>李四</name>" + "<sex>女</sex>" + "<age>28</age>" + "</employee>";
    convertToObject(p, xml);
  }

  
  public static String convertToXml(Object obj, String encoding) {
    String result = null;
    try {
      JAXBContext context = JAXBContext.newInstance(obj.getClass());
      Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
      marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);

      StringWriter writer = new StringWriter();
      marshaller.marshal(obj, writer);
      result = writer.toString();
      System.out.println(result);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  public static String convertToObject(People p, String xml) {
    String result = null;
    try {
      StringReader sr = new StringReader(xml);
      JAXBContext context = JAXBContext.newInstance(p.getClass());
      Unmarshaller unmarshaller = context.createUnmarshaller();
      p = (People) unmarshaller.unmarshal(sr);
      result = p.toString();
      System.out.println(result);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
}
