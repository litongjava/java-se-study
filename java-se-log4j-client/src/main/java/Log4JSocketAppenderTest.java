import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author litong
 * @date 2018��8��11��_����7:56:08 
 * @version 1.0 
 */
public class Log4JSocketAppenderTest {
  public static void main(String[] args) throws InterruptedException {
    //1.�õ������ļ���url
    URL resource = Log4JSocketAppenderTest.class.getResource("/log4j.xml");
    System.out.println("resource:"+resource);
    //2.���������ļ�
    DOMConfigurator.configure(resource);
    //3.��ȡremote��¼��
    Logger logger = LogManager.getLogger("remote");
    //4.д����־
    while(true) {
      logger.info("��ӡ��־��Զ���ļ�ϵͳ");
      Thread.sleep(3);
    }
    
  }
}
