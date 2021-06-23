package com.alit.sutdy.opencv.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import com.alit.sutdy.opencv.util.OpenCVLibraryUtil;
import com.alit.sutdy.opencv.util.OpenCVMatUtil;

public class Sample01OfFaceDetections {

  public static void main(String[] args) {
    OpenCVLibraryUtil.init();
    faceDetections();
  }

  private static void faceDetections() {
    // 打开摄像头
    VideoCapture vc = new VideoCapture(0);
    // 加载模型文件,人脸检测模型
    String openCVDir = "D:\\dev_progream\\opencv-4.1.1";
    String xmlPath = openCVDir + "\\sources\\data\\haarcascades_cuda\\haarcascade_frontalface_default.xml";
    CascadeClassifier faceDetector = new CascadeClassifier(xmlPath);
    // 获取视频帧,存入mat中
    Mat mat = new Mat();
    while (vc.read(mat)) {
      // 使用人脸检测模型,检测mat的数据是否是人脸,如果检测到人脸将检测到的人脸数据存储在faceDetections中
      MatOfRect faceDetections = new MatOfRect();
      faceDetector.detectMultiScale(mat, faceDetections);
      // 输出检测到的人脸数量
      System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

      for (Rect rect : faceDetections.toArray()) {
        // 人脸的左上坐标
        Point leftTop = new Point(rect.x, rect.y);
        // 人脸的右下坐标
        Point rightDown = new Point(rect.x + rect.width, rect.y + rect.height);
        // 颜色
        Scalar color = new Scalar(0, 255, 0);
        // 画出一个矩形在mat中,指定坐标和颜色
        Imgproc.rectangle(mat, leftTop, rightDown, color);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
        String format = sdf.format(new Date());
        String fileName = "face_detect_photo_" + format + ".jpg";
        System.out.println("detect face save:" + fileName);
        OpenCVMatUtil.saveMat(mat, rect, fileName);
      }

      int key = showMat(mat);
      if (key == 27) {
        break;
      }
    }
    // 销毁窗口
    HighGui.destroyAllWindows();
    // 关闭摄像头
    vc.release();
  }

  private static int showMat(Mat mat) {
    // 定义并设置窗口的名称
    String winName = "showFrame";
    HighGui.namedWindow(winName);
    // 设置窗口的大小
    HighGui.resizeWindow(winName, 800, 600);
    // 窗口中显示图片
    HighGui.imshow(winName, mat);
    // 调用 waitKey,显示窗口
    int key = HighGui.waitKey(1);
    return key;
  }
}