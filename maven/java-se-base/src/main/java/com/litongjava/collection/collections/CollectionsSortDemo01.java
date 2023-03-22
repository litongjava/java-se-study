package com.litongjava.collection.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.litongjava.model.Employee;

public class CollectionsSortDemo01 {
  public static void main(String[] args) {
    List<Employee> list = new ArrayList<>();
    list.add(new Employee("litong", "Developer"));
    list.add(new Employee("zhangsan", "Accounter"));
    list.add(new Employee("wagnwu", "Layer"));

    System.out.println("排序前输出");
    for (Employee employee : list) {
      System.out.println(employee);
    }

    // 排序
    Collections.sort(list, new Comparator<Employee>() {
      @Override
      public int compare(Employee o1, Employee o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.getName(), o2.getName());
      }
    });
    System.out.println("排序后输出");
    for (Employee employee : list) {
      System.out.println(employee);
    }
  }
}
