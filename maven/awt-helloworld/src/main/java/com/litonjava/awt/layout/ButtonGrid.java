package com.litonjava.awt.layout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class ButtonGrid {

  public static void main(String[] args) {
    // 初始化fragme
    Frame f = new Frame("GridLayout");
    // 容器平均分成3行2列
    f.setLayout(new GridLayout(3, 2));
    // 添加到第1行第1格
    f.add(new Button("1"));
    // 添加到第1行第2格
    f.add(new Button("2"));
    // 添加到第2行第1格
    f.add(new Button("3"));
    // 添加到第2行第2格
    f.add(new Button("4"));
    // 添加到第3行第1格
    f.add(new Button("5"));
    // 添加到第3行第2格
    f.add(new Button("6"));
    f.setSize(300, 300);
    f.setVisible(true);
  }
}
