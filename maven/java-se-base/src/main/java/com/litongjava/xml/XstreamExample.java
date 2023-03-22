package com.litongjava.xml;

import com.thoughtworks.xstream.XStream;

/**
 * @author litong
 * @date 2018年12月4日_下午6:56:42 
 * @version 1.0 
 */
public class XstreamExample {
  public static void main(String[] args) {
//    beanToXMLExample();
    // xmlToBeanExample();
    beanToXMLWithAnnotation();
  }

  public static void beanToXMLExample() {
    User user = new User("username", "password");
    // 创建xml解析对象
    XStream xStream = new XStream();
    XStream.setupDefaultSecurity(xStream);
    // 设置别名,否则会输出类全路径
    xStream.alias("user", User.class);
    // 转换为xml
    String xml = xStream.toXML(user);
    System.out.println(xml);
  }

  public static void xmlToBeanExample() {
    String xml = "<user><username>username</username><password>password</password></user>";
    // 创建xml解析对象
    XStream xStream = new XStream();
    // 设置默认安全防护
    xStream.setupDefaultSecurity(xStream);
    // 设置允许的类
    xStream.allowTypes(new Class[] { User.class });
    // 设置类的别名
    xStream.alias("user", User.class);
    // xml转bean
    User user = (User) xStream.fromXML(xml);
    System.out.println(user);
  }

  public static void beanToXMLWithAnnotation() {
    User user = new User("litong", "password");
    XStream xStream = new XStream();
    // 声明XStream注解来源
    xStream.processAnnotations(User.class);
    String xml = xStream.toXML(user);
    System.out.println(xml);
  }
}
