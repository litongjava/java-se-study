package com.xml;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * @author Administrator
 * @date 2019年2月11日_上午10:32:00 
 * @version 1.0 
 */
public class XMLDocumentTest {

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void test() {
  }

  @Test
  public void test1() throws ParserConfigurationException, TransformerException {
    // 1.生成DOM对象
    // 创建DocumentBuilderFactory
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    // 创建DocumentBuilder：
    DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
    // 创建dom对象：
    Document document = builder.newDocument();
    // 创建dom中根元素,并添到DOM对象中：
    Element rootElement = document.createElement("根元素名");
    document.appendChild(rootElement);
    // 创建子元素,设置子元素属性,向子元素添加文本内容,添加到根元素中,dom树就是通过不停appendChild形成的
    Element childElement = document.createElement("子元素名");
    childElement.setAttribute("属性名", "属性值");
    childElement.setTextContent("标签间内容");
    rootElement.appendChild(childElement);

    // 2.把dom对象导出到Write流
    // 创建转换器工厂
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    // 由工厂创建转换器实例：
    Transformer transformer = transformerFactory.newTransformer();
    // 设置转换格式,设置输出到文档时的格式，编码,换行等：
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    // 由转换器把dom资源转换到结果输出流
    StringWriter stringWriter = new StringWriter();
    StreamResult streamResult = new StreamResult(stringWriter);
    DOMSource domSource = new DOMSource(document);
    transformer.transform(domSource, streamResult);
    System.out.println(stringWriter);
  }

  @Test
  public void test2() throws ParserConfigurationException, SAXException, IOException {
    // 将xml内容转换为InputSource
    String msg = "<xml><ToUserName><![CDATA[oia2TjjewbmiOUlr6X-1crbLOvLw]]></ToUserName><FromUserName><![CDATA[gh_7f083739789a]]></FromUserName><CreateTime>1407743423</CreateTime><MsgType><![CDATA[video]]></MsgType><Video><MediaId><![CDATA[eYJ1MbwPRJtOvIEabaxHs7TX2D-HV71s79GUxqdUkjm6Gs2Ed1KF3ulAOA9H1xG0]]></MediaId><Title><![CDATA[testCallBackReplyVideo]]></Title><Description><![CDATA[testCallBackReplyVideo]]></Description></Video></xml>";
    StringReader stringReader = new StringReader(msg);
    InputSource inputSource = new InputSource(stringReader);
    // 创建factory
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    // 创建builder
    DocumentBuilder db = dbf.newDocumentBuilder();
    // 解析成document
    Document document = db.parse(inputSource);
    // 获取rootElement
    Element rootElement = document.getDocumentElement();
    NodeList nodelist1 = rootElement.getElementsByTagName("ToUserName");
    NodeList nodelist2 = rootElement.getElementsByTagName("FromUserName");
    // 获取内容
    String toUserName = nodelist1.item(0).getTextContent();
    String fromUserName = nodelist2.item(0).getTextContent();
    System.out.println(toUserName + "," + fromUserName);
  }

}
