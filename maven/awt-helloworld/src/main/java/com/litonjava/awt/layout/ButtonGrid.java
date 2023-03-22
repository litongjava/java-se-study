package com.litonjava.awt.layout;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;

public class ButtonGrid {

  public static void main(String[] args) {
    // ��ʼ��fragme
    Frame f = new Frame("GridLayout");
    // ����ƽ���ֳ�3��2��
    f.setLayout(new GridLayout(3, 2));
    // ��ӵ���1�е�1��
    f.add(new Button("1"));
    // ��ӵ���1�е�2��
    f.add(new Button("2"));
    // ��ӵ���2�е�1��
    f.add(new Button("3"));
    // ��ӵ���2�е�2��
    f.add(new Button("4"));
    // ��ӵ���3�е�1��
    f.add(new Button("5"));
    // ��ӵ���3�е�2��
    f.add(new Button("6"));
    f.setSize(300, 300);
    f.setVisible(true);
  }
}
