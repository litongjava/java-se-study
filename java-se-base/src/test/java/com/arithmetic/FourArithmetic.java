package com.arithmetic;

import java.util.Random;
import java.util.Scanner;

/**
 * @author litong
 * @date 2018年9月12日_上午11:30:04 
 * @version 1.0 
 */
public class FourArithmetic {
  public static void main(String[] args) {
    // 获取用户数据
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    // 答对1道题得1分
    int score = 0;
    while (true) {
      System.out.println("进入程序,输入101退出");
      // 随机生成第1个数
      int l1 = random.nextInt(10);
      // 随机生成第2个数
      int l2 = random.nextInt(10);
      // 生成四则运算 ,1+,2+,3X,4/
      random.setSeed(System.currentTimeMillis());
      int yunsuan = random.nextInt(4);
      int result = 0;
      if (yunsuan == 1) {
        result = l1 + l2;
        System.out.println(l1 + "+" + l2);
      } else if (yunsuan == 2) {
        result = l1 - l2;
        System.out.println(l1 + "-" + l2);
      } else if (yunsuan == 3) {
        result = l1 * l2;
        System.out.println(l1 + "x" + l2);
      } else{
        result = l1 / l2;
        System.out.println(l1 + "/" + l2);
      }
      int input = scanner.nextInt();
      if (result == input) {
        score++;
        System.out.println("正确");
      } else if (input == 101) {
        System.out.println("退出");
        break;
      } else {
        System.out.println("错误");
      }
    }
    System.out.println("你的成绩是" + score);
  }
}
