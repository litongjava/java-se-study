package com.litonjava.awt.event;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import lombok.extern.slf4j.Slf4j;

public class TestButton {

  public static void main(String[] args) {
    //创建frame
    Frame f = new Frame("Test");
    //创建button
    JButton b = new JButton("单击我");
    
    //添加事件处理者
    b.addActionListener(new ButtonHandler());
    f.setLayout(new FlowLayout());
    f.setSize(200, 200);
    f.add(b);
    f.setVisible(true);

  }
}

@Slf4j
//实现接口ActionListener才能充当事件ActionEvent的处理者
class ButtonHandler implements ActionListener {
  // 系统产生的ActionEvent事件对象被当前做参数传递给该方法
  public void actionPerformed(ActionEvent e) {
    log.info("e:{}", e);
  }
}
