package com.litongjava.functioninterface;

public class VUtils {
  /**
   * 如果参数为true抛出异常
   * 
   * @param b
   * @return
   **/
  public static ThrowExceptionFunction isTure(boolean b) {

    return (errorMessage) -> {
      if (b) {
        throw new RuntimeException(errorMessage);
      }
    };
  }

  public static ThrowExceptionFunction isTure2(boolean b) {

    return new ThrowExceptionFunction() {

      @Override
      public void throwMessage(String errorMessage) {
        if (b) {
          throw new RuntimeException(errorMessage);
        }
      }
    };
  }

  /**
   * 参数为true或false时，分别进行不同的操作
   * 
   * @param b
   * @return com.example.demo.func.BranchHandle
   **/
  public static BranchHandle isTureOrFalse(boolean b) {

    return (trueHandle, falseHandle) -> {
      if (b) {
        trueHandle.run();
      } else {
        falseHandle.run();
      }
    };
  }

  /***
   * 参数为true或false时，分别进行不同的操作**
   * 
   * @param b
   * @return
   **/
  public static PresentOrElseHandler<?> isBlankOrNoBlank(String str) {

    return (consumer, runnable) -> {
      if (str == null || str.length() == 0) {
        runnable.run();
      } else {
        consumer.accept(str);
      }
    };
  }
}
