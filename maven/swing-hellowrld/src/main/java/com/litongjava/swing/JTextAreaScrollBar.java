package com.litongjava.swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JTextAreaScrollBar {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    // 用于关闭窗体
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // 设置为绝对布局
    frame.getContentPane().setLayout(null);

    // 创建一个JTextArea，这里不必设置大小。（设置大小后似乎显示不了滚动条）
    JTextArea text1 = new JTextArea("置换结果显示区域");

    // 创建滚动条面板
    JScrollPane scrollpane = new JScrollPane();
    // 分别设置水平和垂直滚动条自动出现 （默认是这种）
    scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

    // 分别设置水平和垂直滚动条总是出现
    scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    // （这是关键！不是用add）把text1组件放到滚动面板里
    scrollpane.setViewportView(text1);
    // 将滚动条面板加到窗体
    frame.add(scrollpane);
    // 放在最后，让整个窗体可视
    frame.setVisible(true);
  }

}
