package com.litonjava.awt.event;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestInnerClass {

  private Frame f;
  private TextField tf;

  public void launchFrame() {
    // 创建frame
    f = new Frame("Inner");
    // 创建TextField
    tf = new TextField(30);
    // 创建label
    Label label = new Label("Click and drag the mouse");

    // 添加组件
    f.add(label, BorderLayout.NORTH);
    f.add(tf, BorderLayout.SOUTH);
    // 为frame添加adapter
    f.addMouseMotionListener(new MyMouseMotionListener());
    f.addWindowListener(new MyWindowListener());
    f.setSize(200, 200);
    f.setVisible(true);
  }

  // MouseMotionAdapter
  class MyMouseMotionListener extends MouseMotionAdapter {
    @Override
    public void mouseDragged(MouseEvent e) {
      int x = e.getX();
      int y = e.getY();
      String template = "Mouse dragging: x = %s, y = %s";
      String text = String.format(template, x, y);
      tf.setText(text);
      log.info("e:{}", e);
      log.info("text:{}", text);
    }
  }

  // WindowAdapter
  class MyWindowListener extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
      log.info("close:{}", e);
      System.exit(1);
    }
  }

  public static void main(String[] args) {
    TestInnerClass tic = new TestInnerClass();
    tic.launchFrame();
  }
}
