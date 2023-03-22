package com.litongjava.xml;

import java.io.StringWriter;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.CDATASection;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author Administrator
 * @date 2019年2月11日_上午11:00:06 
 * @version 1.0 
 */
public class XMLDocumentUtil {
  private static DocumentBuilder builer = null;
  private static Transformer transformer = null;
  static {
    // 定义工厂 API，使应用程序能够从 XML 文档获取生成 DOM 对象树的解析器。
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    // 指定由此工厂创建的解析器在解析 XML 文档时，必须删除元素内容中的空格
    factory.setIgnoringElementContentWhitespace(true);
    try {
      // 使用当前配置的参数创建一个新的 DocumentBuilder 实例。
      builer = factory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
    // (1)创建转换器工厂：
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    // (2)由工厂创建转换器实例：
    try {
      transformer = transformerFactory.newTransformer();
    } catch (TransformerConfigurationException e) {
      e.printStackTrace();
    }
  }

  /**
   * 生成测试成功的xml
   * 样本如下
   * <?xml version="1.0" encoding="UTF-8" standalone="no"?>
   * <xml>
   * <ToUserName><![CDATA[oK3R8wvwCN_QjAIetsQl6jSShsm8]]></ToUserName>
   * <FromUserName><![CDATA[gh_1895c60b0323]]></FromUserName>
   * <CreateTime>1519832991</CreateTime>
   * <MsgType><![CDATA[text]]></MsgType>
   * <Content><![CDATA[ {rollback} ]></Content>
   * </xml>
   */

  public String toWechatXML(Map<String, String> msgMap) {
    // 创建xml文档
    Document dom = builer.newDocument();
    // 创建根元素
    Element rootEle = dom.createElement("xml");
    dom.appendChild(rootEle);

    Element toUserNameEle = dom.createElement("ToUserName");
    CDATASection toUserNameEleCDATE = dom.createCDATASection(msgMap.get("FromUserName"));
    toUserNameEle.appendChild(toUserNameEleCDATE);
    rootEle.appendChild(toUserNameEle);

    Element fromUserNameEle = dom.createElement("FromUserName");
    CDATASection fromUserNameEleCDATE = dom.createCDATASection(msgMap.get("ToUserName"));
    fromUserNameEle.appendChild(fromUserNameEleCDATE);
    rootEle.appendChild(fromUserNameEle);

    Element createTimeEle = dom.createElement("CreateTime");
    createTimeEle.setTextContent(msgMap.get("CreateTime"));
    rootEle.appendChild(createTimeEle);

    Element msgTypeEle = dom.createElement("MsgType");
    CDATASection msgTypeEleCDATA = dom.createCDATASection("text");
    msgTypeEle.appendChild(msgTypeEleCDATA);
    rootEle.appendChild(msgTypeEle);

    Element contentEle = dom.createElement("Content");
    CDATASection contentEleCDATE = dom.createCDATASection(msgMap.get("Content"));
    contentEle.appendChild(contentEleCDATE);
    rootEle.appendChild(contentEle);

    StringWriter stringWriter = new StringWriter();
    try {
      transformer.transform(new DOMSource(dom), new StreamResult(stringWriter));
    } catch (TransformerException e) {
      e.printStackTrace();
    }
    return stringWriter.toString();
  }
}
