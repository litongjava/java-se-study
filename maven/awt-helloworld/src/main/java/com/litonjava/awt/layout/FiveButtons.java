package com.litonjava.awt.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;

public class FiveButtons {

  public static void main(String[] args) {
    // ��ʼ��frame
    Frame f = new Frame("BorderLayout");
    f.setLayout(new BorderLayout());
    // ��Ӱ�ť
    // ��һ��������ʾ�Ѱ�ť��ӵ�������North����
    f.add("North", new Button("North"));
    // ��һ��������ʾ�Ѱ�ť��ӵ�������South����
    f.add("South", new Button("South"));
    // ��һ��������ʾ�Ѱ�ť��ӵ�������West����
    f.add("West", new Button("West"));
    // ��һ��������ʾ�Ѱ�ť��ӵ�������East����
    f.add("East", new Button("East"));
    // ��һ��������ʾ�Ѱ�ť��ӵ�������Center����
    f.add("Center", new Button("Center"));
    f.setSize(300, 300);
    f.setVisible(true);
  }

}
