package com.litongjava.swing;

import javax.swing.JFrame;

/**
 * @author Ping E Lee
 * 程序入口
 */
@SuppressWarnings("serial")
public class MainJFrame extends JFrame {

  public MainJFrame() {
    setTitle("窗口");
    setSize(300, 200);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    addKeyListener(new MyKeyListener());
  }
}
