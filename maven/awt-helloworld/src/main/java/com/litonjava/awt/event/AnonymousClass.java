package com.litonjava.awt.event;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AnonymousClass {

  private Frame f;
  private TextField tf;

  public AnonymousClass() {
    f = new Frame("Inner");
    tf = new TextField(30);
  }

  public void launchFrame() {
    Label label = new Label("Click and drag the mouse");
    f.add(label, BorderLayout.NORTH);
    f.add(tf, BorderLayout.SOUTH);
    // 添加匿名类
    f.addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        String s = "Mouse dragging: x = " + e.getX() + "y = " + e.getY();
        tf.setText(s);
      }
    });
    f.addWindowListener(new WindowAdapter() { 
      public void windowClosing(WindowEvent e) {
        System.exit(1);
      }
    }); // 匿名类结束
    f.setSize(200, 200);
    f.setVisible(true);
  }

  public static void main(String[] args) {
    AnonymousClass obj = new AnonymousClass();
    obj.launchFrame();
  }
}
