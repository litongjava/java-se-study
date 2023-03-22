package com.litongjava.swing;

import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GroupLayoutTest extends JFrame {

  // 标题,账号,密码
  private JLabel titleLabel;
  private JLabel userLabel;
  private JLabel pswdLabel;

  // 账号,密码
  private JTextField userTextField;
  private JPasswordField pswdField;

  // 记住密码,自动登录
  private JRadioButton rememberPaswordRadioButton;
  private JRadioButton autoLoginRadioButton;
  // 登录
  private JButton signInButton;
  private JButton signUpButton;

  public static void main(String[] args) {
    GroupLayoutTest groupLayoutTest = new GroupLayoutTest();
    groupLayoutTest.start();
  }

  private void start() {
    // #设置基本属性#
    this.setVisible(true);
    this.setSize(250, 220);
    this.setVisible(true);
    this.setLocation(400, 200);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 为指定的 Container 创建 GroupLayout
    //1.创建GroupLayout
    Container container= this.getContentPane();
    GroupLayout layout = new GroupLayout(container);
    //2.为container设置layout
    container.setLayout(layout);


    // 创建GroupLayout的水平连续组，越先加入的ParallelGroup，优先级级别越高。
    GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
    // 添加间隔
    hGroup.addGap(5);
    
    ParallelGroup userAndPswdLabel = layout.createParallelGroup().addComponent(userLabel).addComponent(pswdLabel);
    hGroup.addGroup(userAndPswdLabel);
    hGroup.addGap(5);
    
    ParallelGroup addComponent = layout.createParallelGroup().addComponent(titleLabel)
        .addComponent(pswdField).addComponent(userTextField)
        .addComponent(rememberPaswordRadioButton).addComponent(autoLoginRadioButton)
        .addComponent(signInButton);
    hGroup.addGroup(addComponent);
    hGroup.addGap(5);
    // 设置水平分组
    layout.setHorizontalGroup(hGroup);
    
    // 创建GroupLayout的垂直连续组，，越先加入的ParallelGroup，优先级级别越高。
    GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
    vGroup.addGap(10);
    vGroup.addGroup(layout.createParallelGroup().addComponent(titleLabel));
    vGroup.addGap(10);
    vGroup.addGroup(layout.createParallelGroup().addComponent(userLabel).addComponent(userTextField));
    vGroup.addGap(5);
    vGroup.addGroup(layout.createParallelGroup().addComponent(pswdLabel).addComponent(pswdField));
    vGroup.addGroup(layout.createParallelGroup().addComponent(rememberPaswordRadioButton));
    vGroup.addGroup(layout.createParallelGroup().addComponent(autoLoginRadioButton));
    vGroup.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(signInButton));
    vGroup.addGap(10);
    // 设置垂直组
    layout.setVerticalGroup(vGroup);  

  }

  public GroupLayoutTest() {
    // #实例化组件#
    titleLabel = new JLabel("登陆界面");
    userLabel = new JLabel("账号：");
    pswdLabel = new JLabel("密码：");

    userTextField = new JTextField();
    pswdField = new JPasswordField();

    rememberPaswordRadioButton = new JRadioButton("记住密码");
    autoLoginRadioButton = new JRadioButton("自动登陆");

    signInButton = new JButton("登陆");
    signUpButton = new JButton("注册");

  }

}