package com.uairobot.bill.awt;
 
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
@SuppressWarnings("serial")
public class JFrameLayout extends JFrame{
	JButton jb1,jb2,jb3,jb4,jb5,jb6;
	JPanel jp1,jp2;
	public static void main(String[] args) {
		JFrameLayout demo=new JFrameLayout();
	}
	public JFrameLayout(){
		jb1=new JButton("����");
		jb2=new JButton("ƻ��");
		jb3=new JButton("�㽶");
		jb4=new JButton("��֦");
		jb5=new JButton("����");
		jb6=new JButton("����");
		
		jp1=new JPanel();
		jp2=new JPanel();
		
		jp1.add(jb1);
		jp1.add(jb2);
		jp2.add(jb4);
		jp2.add(jb5);
		jp2.add(jb6);
		
		this.add(jp1,BorderLayout.NORTH);
		this.add(jp2,BorderLayout.SOUTH);
		this.add(jb3);
		
		this.setTitle("���ֲ��ָ�ʽ");
		this.setSize(400,200);
		this.setLocation(300,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
 
}