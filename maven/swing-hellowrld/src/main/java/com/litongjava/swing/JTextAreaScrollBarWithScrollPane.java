package com.litongjava.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextAreaScrollBarWithScrollPane {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(400, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTextArea text1 = new JTextArea("置换结果显示区域");
    // 创建一个普通面板
    JPanel panel = new JPanel();
    // 设置普通面板位置和大小，不能省略
    panel.setBounds(20, 20, 100, 50);
    // 让JTextArea平铺整个JPanel
    panel.setLayout(new BorderLayout());
    // 将文本域添加进普通面板
    panel.add(text1);

    JScrollPane scrollpane = new JScrollPane();
    // 设置滚动条面板位置和大小
    scrollpane.setBounds(20, 20, 100, 50);
    // 将普通面板嵌入带滚动条的面板，所在位置由后者决定
    scrollpane.getViewport().add(panel);
    // 将滚动条面板加到窗体
    frame.add(scrollpane);
    frame.setVisible(true);
  }

}
