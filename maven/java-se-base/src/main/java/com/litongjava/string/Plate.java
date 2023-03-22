package com.litongjava.string;

import java.util.Arrays;

public class Plate {
  public static void main(String[] args) {
    String plate = "国A-472U6";
    // 拼接数组,组成完成的车牌信息
    StringBuffer stringBuffer = new StringBuffer();
    // 提取出有效的车牌信息
    if (plate.contains("国")) {
      int guoIndexOf = plate.lastIndexOf("国");
      String plateLetter = plate.substring(guoIndexOf + 1, plate.length());
      if (plateLetter.contains("-")) {
        String[] splitPlateLetter = plateLetter.split("-");
        //
        if (splitPlateLetter.length > 1) {
          for (String string : splitPlateLetter) {
            stringBuffer.append(string);
          }
        }
      }
    }
    String plateCode = stringBuffer.toString();
    System.out.println(plateCode);
    byte[] plateData = stringBuffer.toString().getBytes();
    System.out.println(plateData.length);
  }
}
