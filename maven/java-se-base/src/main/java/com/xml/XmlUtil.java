package com.xml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by litong on 2015/5/19.
 */
public class XmlUtil {
  /**
   * 
   * @param xml
   * @return
   * @throws JDOMException
   * @throws IOException
   */
  public static JSONObject xml2JSON(byte[] xml) throws JDOMException, IOException {
    JSONObject json = new JSONObject();
    InputStream inputStream = new ByteArrayInputStream(xml);

    SAXBuilder saxBuilder = new SAXBuilder();
    Document document = saxBuilder.build(inputStream);
    Element root = document.getRootElement();
    json.put(root.getName(), iterateElement(root));
    return json;
  }

  private static JSONObject iterateElement(Element element) {
    List node = element.getChildren();
    Element et = null;
    JSONObject obj = new JSONObject();
    List list = null;
    for (int i = 0; i < node.size(); i++) {
      list = new LinkedList();
      et = (Element) node.get(i);
      if (et.getTextTrim().equals("")) {
        if (et.getChildren().size() == 0)
          continue;
        if (obj.containsKey(et.getName())) {
          list = (List) obj.get(et.getName());
        }
        list.add(iterateElement(et));
        obj.put(et.getName(), list);
      } else {
        if (obj.containsKey(et.getName())) {
          list = (List) obj.get(et.getName());
        }
        list.add(et.getTextTrim());
        obj.put(et.getName(), list);
      }
    }
    return obj;
  }

  public static void main(String[] args) throws JDOMException, IOException {
    // String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><MoBaoAccount
    // MessageType=\"UserMobilePay\"
    // PlatformID=\"b2ctest\"><OrderNo>M20150521084825</OrderNo><TradeAmt>5000.00</TradeAmt><Commission>0.5</Commission><UserID>zhuxiaolong</UserID><MerchID>zhuxiaolong1</MerchID><tradeType>0</tradeType><CustParam>123</CustParam>
    // <NotifyUrl>http://mobaopay.com/callback.do</NotifyUrl><TradeSummary>订单</TradeSummary></MoBaoAccount>";
    String xml="<user>\r\n" + 
        "  <username>litong</username>\r\n" + 
        "  <password>password</password>\r\n" + 
        "</user>";
    JSONObject json = xml2JSON(xml.getBytes());
    System.out.println(json.toJSONString());
  }
}