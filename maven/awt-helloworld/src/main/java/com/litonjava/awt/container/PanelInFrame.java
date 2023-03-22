package com.litonjava.awt.container;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;


@SuppressWarnings("serial")
public class PanelInFrame extends Frame {
  public static void main(String[] args) {
    //初始化frame
    PanelInFrame fr = new PanelInFrame("Frame with Panel");
    fr.setSize(250, 250);
    fr.setBackground(Color.blue);
    fr.setLayout(null); // 取消布局管理器
    
    //初始化pannel
    Panel pan = new Panel();
    pan.setSize(100, 100);
    pan.setBackground(Color.green);

    //frame添加panel
    fr.add(pan);
    fr.setVisible(true);
  }

  public PanelInFrame(String str) {
    super(str);
  }
}
