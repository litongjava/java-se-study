package com.litonjava.awt.layout;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestCardLayout {
  private Panel p1, p2, p3;
  private Button b1, b2, b3;
  private Frame f;
  private CardLayout cardLayout = new CardLayout();

  public void create() {
    // 创建button
    b1 = new Button("第1个");
    b2 = new Button("第2个");
    b3 = new Button("第3个");

    // 创建panel
    p1 = new Panel();
    p2 = new Panel();
    p3 = new Panel();

    // 创建ActionListener
    MyActionListener myActionListener = new MyActionListener();

    // 初始化fragme
    f = new Frame("Test");
    // 添加button到panel
    p1.add(b1);
    b1.addActionListener(myActionListener); // 注册监听器
    p2.add(b2);
    b2.addActionListener(myActionListener);
    p3.add(b3);
    b3.addActionListener(myActionListener);

    // 添加panel到frame
    f.setLayout(cardLayout);
    f.add(p1, "第一层");
    f.add(p2, "第二层");
    f.add(p3, "第三层");
    f.setSize(200, 100);
    f.setVisible(true);
  }

  private class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      log.info("检测到单击:{}", e);
      // 当按钮被单击时，实现下一张卡片的功能
      cardLayout.next(f);
    }
  }
  
  public static void main(String[] args) {
    TestCardLayout tc = new TestCardLayout();
    tc.create();
  }
}
