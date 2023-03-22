package com.litongjava.http;

import java.io.IOException;

public class UploadDemo {

  public static void main(String[] args) throws IOException {
    String uploadRequestUrl = "http://192.168.104.3:10041/opencv-engine/image/upload";
    String localFilePath = "D:\\PlateDetect\\08_物联网比赛真实车牌\\车牌-距离-0.jpg";
    HttpUploadUtils.upload(uploadRequestUrl, localFilePath);
  }

}
