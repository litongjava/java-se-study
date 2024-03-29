package com.litongjava.captcha;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 无名
 * @version 1.0
 * @ClassName: CaptchaUtil
 * @Description: 关于验证码的工具类
 * @date 2016-5-7 上午8:33:08
 */
@Slf4j
public final class CaptchaUtils {
  private CaptchaUtils() {
  }

  /*
   * 随机字符字典
   */
  private static final char[] CHARS = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
      'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

  /*
   * 随机数
   */
  private static Random random = new Random();

  /*
   * 获取6位随机数
   */
  private static String getRandomString() {
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < 6; i++) {
      buffer.append(CHARS[random.nextInt(CHARS.length)]);
    }
    return buffer.toString();
  }

  /*
   * 获取随机数颜色
   */
  private static Color getRandomColor() {
    return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
  }

  /*
   * 返回某颜色的反色
   */
  private static Color getReverseColor(Color c) {
    return new Color(255 - c.getRed(), 255 - c.getGreen(), 255 - c.getBlue());
  }

  public static void outputCaptcha(String id, OutputStream output) throws IOException {

    String randomString = getRandomString();
    log.info("{},{}", id, randomString);
    int width = 100;
    int height = 30;

    Color color = getRandomColor();
    Color reverse = getReverseColor(color);

    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics2D g = bi.createGraphics();
    g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
    g.setColor(color);
    g.fillRect(0, 0, width, height);
    g.setColor(reverse);
    g.drawString(randomString, 18, 20);
    for (int i = 0, n = random.nextInt(100); i < n; i++) {
      g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
    }

    // 转成JPEG格式
    JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(output);
    encoder.encode(bi);
    output.flush();
  }
}