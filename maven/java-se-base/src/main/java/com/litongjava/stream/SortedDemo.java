package com.litongjava.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedDemo {
  public static void main(String[] args) {
    m();
  }

  public static void printStudents(List<Student> studentList) {
    System.out.println("【姓名】\t【年龄】\t【身高】");
    System.out.println("-----------------------");
    studentList.forEach(f -> System.out.println(f.toString()));
    System.out.println(" ");
  }

  public static void m() {
    ArrayList<Student> list = new ArrayList<>();
    list.add(new Student("张三", 11, 180));
    list.add(new Student("李四", 11, 179));
    list.add(new Student("王五", 11, 170));
    list.add(new Student("八戒", 22, 169));
    list.add(new Student("悟空", 33, 160));
    // 根据年龄升序来排列,年龄相同根据身高升序
    List<Student> ascCollect = list.stream()
        //
        .sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getHeight))
        .collect(Collectors.toList());
    printStudents(ascCollect);

    // 根据年龄降序来排列，年龄相同身高降序
    List<Student> descCollect = list.stream()
        //
        .sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getHeight).reversed())
        .collect(Collectors.toList());
    printStudents(descCollect);

    // 根据年龄降序来排列，年龄相同身高升序
    List<Student> sorted = list.stream()
        //
        .sorted(Comparator.comparing(Student::getAge).reversed().thenComparing(Student::getHeight))
        .collect(Collectors.toList());
    printStudents(sorted);

  }
}
