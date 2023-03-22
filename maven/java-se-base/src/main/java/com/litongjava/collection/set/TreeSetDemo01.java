package com.litongjava.collection.set;

import java.util.TreeSet;

public class TreeSetDemo01 {
  public static void main(String[] args) {
    // 键盘录入3个学生成绩，存储到集合里；
    TreeSet<Student> treeSet = new TreeSet<Student>();
    treeSet.add(new Student("zhangsan", 100, 100, 100));
    treeSet.add(new Student("lisi", 90, 100, 100));
    treeSet.add(new Student("wangwu", 80, 100, 100));

    System.out.println("共获取到" + treeSet.size() + "个学生的成绩");
    System.out.println("姓名" + "\t总成绩" + "\t语文成绩" + "\t数学成绩" + "\t英语成绩");
    for (Student stu : treeSet) {
      System.out.println(stu.getName() + "\t" + stu.sum() + "\t" + stu.getCnGrade() + "\t" + stu.getMathGrade() + "\t"
          + stu.getEnGrade());
    }
  }
}
