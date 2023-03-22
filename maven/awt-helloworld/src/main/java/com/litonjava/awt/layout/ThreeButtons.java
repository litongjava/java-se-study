package com.litonjava.awt.layout;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class ThreeButtons {

  public static void main(String[] args) {
    //初始化fragme
    Frame f = new Frame();
    f.setLayout(new FlowLayout());
    
    //初始化button
    Button button1 = new Button("Yes");
    Button button2 = new Button("No");
    Button button3 = new Button("Close");
    
    //添加button
    f.add(button1);
    f.add(button2);
    f.add(button3);
    f.setSize(300, 150);
    f.setVisible(true);
  }
}
