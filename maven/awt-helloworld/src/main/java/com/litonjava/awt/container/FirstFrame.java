package com.litonjava.awt.container;

import java.awt.Color;
import java.awt.Frame;

@SuppressWarnings("serial")
public class FirstFrame extends Frame {

  public static void main(String[] args) {
    // ʵ����frame����������
    FirstFrame fr = new FirstFrame("First contianer!!");
    // ����Frame�Ĵ�С
    fr.setSize(240, 240);
    // ����Frame�ı���ɫ
    fr.setBackground(Color.yellow);
    // ����FrameΪ�ɼ�
    fr.setVisible(true);
  }

  public FirstFrame(String str) {
    // ���ø���Ĺ��췽��
    super(str);
  }

}