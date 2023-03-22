package com.litonjava.awt.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class FiveButtons {

  public static void main(String[] args) {
    // 初始化frame
    Frame f = new Frame("BorderLayout");
    f.setLayout(new BorderLayout());
    // 添加按钮
    // 第一个参数表示把按钮添加到容器的North区域
    f.add("North", new Button("North"));
    // 第一个参数表示把按钮添加到容器的South区域
    f.add("South", new Button("South"));
    // 第一个参数表示把按钮添加到容器的West区域
    f.add("West", new Button("West"));
    // 第一个参数表示把按钮添加到容器的East区域
    f.add("East", new Button("East"));
    // 第一个参数表示把按钮添加到容器的Center区域
    f.add("Center", new Button("Center"));
    f.setSize(300, 300);
    f.setVisible(true);
  }

}
