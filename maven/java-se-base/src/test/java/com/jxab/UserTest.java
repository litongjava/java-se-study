package com.jxab;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import com.litongjava.xml.User;

/**
 * @author Administrator
 * @date 2019年1月23日_下午6:14:42 
 * @version 1.0 
 */
public class UserTest {
  @Test
  public void test() {
    User user = new User("litong", "123456");
    StringWriter stringWriter = new StringWriter();
    JAXBContext jaxbContext;
    Marshaller marshaller;
    try {
      jaxbContext = JAXBContext.newInstance(User.class);
      marshaller = jaxbContext.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
      marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
      marshaller.marshal(user, stringWriter);
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    String string = stringWriter.toString();
    System.out.println(string);
  }
}
