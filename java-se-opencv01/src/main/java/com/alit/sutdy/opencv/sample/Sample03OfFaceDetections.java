package com.alit.sutdy.opencv.sample;

import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import com.alit.sutdy.opencv.util.OpenCVLibraryUtil;
import com.alit.sutdy.opencv.util.OpenCVMatUtil;

/**
 * 
 * @author litongjava 检测图片中是否包含人脸
 *
 */
public class Sample03OfFaceDetections {
  public static void main(String[] args) {
    OpenCVLibraryUtil.init();
    faceDetection();
  }

  private static void faceDetection() {
    // 获取摄像头视频流
    VideoCapture capture = new VideoCapture(0);
    MatPanel panel = new MatPanel();

    int height = (int) capture.get(Videoio.CAP_PROP_FRAME_HEIGHT);
    int width = (int) capture.get(Videoio.CAP_PROP_FRAME_WIDTH);
    if (height == 0 || width == 0) {
      System.out.println("camera not found! exit");
      System.exit(0);
    }

    JFrame frame = new JFrame("camera");
    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    frame.setContentPane(panel);
    frame.setVisible(true);
    Insets insets = frame.getInsets();
    // 设置宽带和高度
    frame.setSize(width + insets.left + insets.right, height + insets.top + insets.bottom);

    Mat mat = new Mat();
    while (frame.isShowing()) {
      // 获取视频帧
      capture.read(mat);
      // 识别人脸
      mat = detectFace(mat);
      // 转为图像显示
      panel.setBufferedImage(mat2BufferImage(mat));
      // repaint自动调用paint
      panel.repaint();
    }
    capture.release();
    frame.dispose();
  }

  /**
   * 转换图像
   */
  private static BufferedImage mat2BufferImage(Mat mat) {
    int dataSize = mat.cols() * mat.rows() * (int) mat.elemSize();
    byte[] data = new byte[dataSize];
    mat.get(0, 0, data);

    int type = mat.channels() == 1 ? BufferedImage.TYPE_BYTE_GRAY : BufferedImage.TYPE_3BYTE_BGR;
    if (type == BufferedImage.TYPE_3BYTE_BGR) {
      for (int i = 0; i < dataSize; i += 3) {
        byte blue = data[i + 0];
        data[i + 0] = data[i + 2];
        data[i + 2] = blue;
      }
    }
    BufferedImage image = new BufferedImage(mat.cols(), mat.rows(), type);
    image.getRaster().setDataElements(0, 0, mat.cols(), mat.rows(), data);

    return image;
  }

  /**
   * opencv实现人脸识别，同时检测到人脸和人眼时才截图
   */
  public static Mat detectFace(Mat mat) {
    // 创建2个人脸检测模型,faceDetector和eyeDetector,检测人脸和眼睛
    String openCVDir = "D:\\dev_progream\\opencv-4.1.1";
    String frontalfaceAltXml = openCVDir + "\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml";
    String eyeXml = openCVDir + "\\sources\\data\\haarcascades\\haarcascade_eye.xml";
    CascadeClassifier faceDetector = new CascadeClassifier(frontalfaceAltXml);
    CascadeClassifier eyeDetector = new CascadeClassifier(eyeXml);

    // 在图片中检测人脸,将结果保存到faceDetections
    MatOfRect faceDetections = new MatOfRect();
    faceDetector.detectMultiScale(mat, faceDetections);

    Rect[] rects = faceDetections.toArray();
    if (rects != null && rects.length >= 1) {
      for (Rect rect : rects) {
        // 画矩形
        Point leftTop = new Point(rect.x, rect.y);
        Point rightDown = new Point(rect.x + rect.width, rect.y + rect.height);
        Scalar color = new Scalar(0, 0, 255);
        Imgproc.rectangle(mat, leftTop, rightDown, color, 2);

        // 识别人眼
        Mat faceROI = new Mat(mat, rect);
        MatOfRect eyesDetections = new MatOfRect();
        eyeDetector.detectMultiScale(faceROI, eyesDetections);
        // 如果识别到人脸,则保存人脸
        if (eyesDetections.toArray().length > 1) {
          SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
          String format = sdf.format(new Date());
          String fileName = "face_detect_photo_" + format + ".jpg";
          System.out.println("detect face save:" + fileName);
          OpenCVMatUtil.saveMat(mat, rect, fileName);
        }
      }
    }
    return mat;
  }
}