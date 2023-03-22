package com.litongjava.collection.set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Comparable<Student> {
  // 姓名,语文成绩,数学成绩,英语成绩
  private String name;
  private Integer cnGrade, mathGrade, enGrade;

  /**
   * 返回总成绩
   * 
   * @return
   */
  public Integer sum() {
    return cnGrade + mathGrade + enGrade;
  }

  @Override
  public int compareTo(Student o) {
    Integer difference = this.sum() - o.sum();
    System.out.println("difference:" + difference);
    return difference;
  }

}
