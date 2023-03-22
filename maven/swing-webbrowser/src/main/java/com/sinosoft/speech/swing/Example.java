package com.sinosoft.speech.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

/**
 * @author lijunming
 * @date 2018/7/22 下午6:00
 */
public class Example extends JPanel {
  private static final long serialVersionUID = 1L;

  private JPanel jp;

  private JWebBrowser jwb;

  public Example(String url) {
    super(new BorderLayout()); // 设置布局方式
    jp = new JPanel(new BorderLayout());
    jwb = new JWebBrowser();
    jwb.navigate(url);
    jwb.setButtonBarVisible(false);
    jwb.setMenuBarVisible(false);
    jwb.setBarsVisible(false);
    jwb.setStatusBarVisible(false);
    jp.add(jwb, BorderLayout.CENTER);
    add(jp, BorderLayout.CENTER);
    // 执行Js代码
    jwb.executeJavascript("alert('hello swing')");
  }

  /**
   * 在swing里内嵌浏览器
   * 
   * @param url
   *          要访问的url
   * @param title
   *          窗体的标题
   */
  public static void openForm(final String url, final String title) {
    UIUtils.setPreferredLookAndFeel();
    NativeInterface.open();
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new JFrame(title);
        // 设置窗体关闭的时候不关闭应用程序
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new Example(url), BorderLayout.CENTER);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationByPlatform(true);
        // 让窗体可见
        frame.setVisible(true);
        // 重置窗体大小
        frame.setResizable(true);
        // 设置窗体的宽度、高度
        frame.setSize(1400, 700);
        // 设置窗体居中显示
        frame.setLocationRelativeTo(frame.getOwner());
      }
    });
    NativeInterface.runEventPump();
  }

  public static void main(String[] args) {
    openForm("http://www.baidu.com", "hello swing");
  }
}
