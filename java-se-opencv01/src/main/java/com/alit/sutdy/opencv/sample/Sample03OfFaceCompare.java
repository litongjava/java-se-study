package com.alit.sutdy.opencv.sample;

import java.util.Arrays;

import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import com.alit.sutdy.opencv.util.OpenCVLibraryUtil;

/**
 * 人脸比对
 */
public class Sample03OfFaceCompare {
  // 初始化人脸探测器
  static CascadeClassifier faceDetector;

  public static void main(String[] args) {
    // 加载库文件
    OpenCVLibraryUtil.init();
    // 初始化检测器
    String openCVDir = "D:\\dev_progream\\opencv-4.1.1";
    String frontalfaceAltXml = openCVDir + "\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml";
    faceDetector = new CascadeClassifier(frontalfaceAltXml);

    String basePicPath = "D:\\FaceOpenCVData\\";
    double compareHist = compareImage(basePicPath + "001.jpg", basePicPath + "duboo开发团队.jpg");
    System.out.println(compareHist);
    if (compareHist > 0.72) {
      System.out.println("人脸匹配");
    } else {
      System.out.println("人脸不匹配");
    }
  }

  /**
   * 比较包含两张人脸的图片,返回图片的相似度
   */
  public static double compareImage(String src, String dst) {
    Mat mat_1 = convertToMat(src);
    Mat mat_2 = convertToMat(dst);

    // 颜色范围
    MatOfFloat ranges = new MatOfFloat(0f, 256f);
    // 直方图大小， 越大匹配越精确 (越慢)
    MatOfInt histSize = new MatOfInt(1000);

    Mat hist_1 = new Mat();
    Mat hist_2 = new Mat();
    Imgproc.calcHist(Arrays.asList(mat_1), new MatOfInt(0), new Mat(), hist_1, histSize, ranges);
    Imgproc.calcHist(Arrays.asList(mat_2), new MatOfInt(0), new Mat(), hist_2, histSize, ranges);

    // CORREL 相关系数
    double res = Imgproc.compareHist(hist_1, hist_2, Imgproc.CV_COMP_CORREL);
    return res;
  }

  /**
   * 1.灰度化 2.取出图片中包含人脸的区域 并返回
   */
  public static Mat convertToMat(String imagePath) {
    Mat image0 = Imgcodecs.imread(imagePath);
    Mat image1 = new Mat();
    // 灰度化
    Imgproc.cvtColor(image0, image1, Imgproc.COLOR_BGR2GRAY);
    // 探测人脸
    MatOfRect faceDetections = new MatOfRect();
    faceDetector.detectMultiScale(image1, faceDetections);
    // 取出rect中人脸图片的范围,并返回
    for (Rect rect : faceDetections.toArray()) {
      Mat face = new Mat(image1, rect);
      return face;
    }
    return null;
  }
}
