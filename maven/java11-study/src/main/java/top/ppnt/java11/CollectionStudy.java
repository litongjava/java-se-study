package top.ppnt.java11;

import java.util.List;

public class CollectionStudy {
  public static void main(String[] args) {
    var list = List.of("Java", "Python", "C");
    var copy = List.copyOf(list);
    System.out.println(list.hashCode());
    System.out.println(copy.hashCode());
    System.out.println(list == copy); // true
  }
}
