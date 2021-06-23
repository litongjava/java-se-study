package com.collection.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamStudy {
  public static void main(String[] args) {
    // collectors();
    // statistics();
    toMap();
  }

  public static void statistics() {
    List<Integer> asList = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    IntSummaryStatistics statistics = asList.stream().mapToInt((x) -> x).summaryStatistics();
    System.out.println("max:" + statistics.getMax());
    System.out.println("min:" + statistics.getMin());
    System.out.println("avg:" + statistics.getAverage());
    System.out.println("sum:" + statistics.getSum());
  }

  public static void collectors() {
    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

    System.out.println("筛选列表: " + filtered);
    String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
    System.out.println("合并字符串: " + mergedString);
  }

  public static void collector() {
    List<String> asList = Arrays.asList("aa", "bb", "cc", "", "aa");
    List<String> filtered = asList.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
    System.out.println(filtered);
  }

  public static void other() {
    Random random = new Random();
    IntStream intStream = random.ints();
    intStream.limit(10).forEach(System.out::println);
    // map方法
    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    // 获取对应的平方数
    List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
    for (Integer i : squaresList) {
      System.out.println(i);
    }
    // filter
    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
    // 获取空字符串的数量
    long count = strings.stream().filter(string -> string.isEmpty()).count();
    System.out.println(count);
  }

  public static void toMap() {
    List<GroupBrandCateBO> list = Arrays.asList(new GroupBrandCateBO("v1", "g1", "b1"),
        new GroupBrandCateBO("v1", "g1", "b1"), new GroupBrandCateBO("v3", "g3", "b3"));

    Map<String, String> map1 = list.stream().collect(
        Collectors.toMap(item -> item.getG(), item -> item.getB(), (oldVal, currVal) -> oldVal, LinkedHashMap::new));
    System.out.println(map1.getClass());
    System.out.println(map1);

    Map<String, String> map2 = list.stream()
        .collect(Collectors.toMap(item -> item.getG(), item -> item.getB(), (oldVal, currVal) -> oldVal));
    System.out.println(map2.getClass());
    System.out.println(map2.toString());
    //Exception in thread "main" java.lang.IllegalStateException: Duplicate key g1
    Map<String, String> map3 = list.stream().collect(Collectors.toMap(GroupBrandCateBO::getG, GroupBrandCateBO::getB));
    System.out.println(map3.getClass());
    System.out.println(map3.toString());
  }
}
