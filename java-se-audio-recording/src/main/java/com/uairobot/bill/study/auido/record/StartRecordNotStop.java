package com.uairobot.bill.study.auido.record;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

public class StartRecordNotStop {
  AudioFormat audioFormat;
  TargetDataLine targetDataLine;

  public static void main(String args[]) {
    StartRecordNotStop recorder = new StartRecordNotStop();
    System.out.println("开始录音");
    recorder.captureAudio();
  }

  public void captureAudio() {
    // 构造具有线性 PCM 编码和给定参数的 AudioFormat。
    audioFormat = getAudioFormat();
    // 根据指定信息构造数据行的信息对象，这些信息包括单个音频格式。此构造方法通常由应用程序用于描述所需的行。
    // lineClass - 该信息对象所描述的数据行的类,format - 所需的格式
    DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);

    // 指定的文件类型
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
    // 设置文件类型和文件扩展名
    File audioFile = new File("test.wav");

    try {
      // 获取TargetDataLine
      targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
      // format - 所需音频格式
      targetDataLine.open(audioFormat);

      // 开始音频捕获
      targetDataLine.start();
      // 构造从指示的目标数据行读取数据的音频输入流。该流的格式与目标数据行的格式相同,
      // line - 此流从中获得数据的目标数据行。stream - 包含要写入文件的音频数据的音频输入流,
      // fileType - 要写入的音频文件的种类,out - 应将文件数据写入其中的外部文件
      AudioSystem.write(new AudioInputStream(targetDataLine), fileType, audioFile);
    } catch (LineUnavailableException | IOException e) {
      e.printStackTrace();
    } finally {
      //如果在console中点击关闭按钮,下面的代码并不会执行
      System.out.println("停止录音");
      targetDataLine.stop();
      targetDataLine.close();
    }
  }

  private AudioFormat getAudioFormat() {
    float sampleRate = 8000F;
    // 8000,11025,16000,22050,44100 采样率
    int sampleSizeInBits = 16;
    // 8,16 每个样本中的位数
    int channels = 2;
    // 1,2 信道数（单声道为 1，立体声为 2，等等）
    boolean signed = true;
    // true,false 指示是以 big-endian 顺序还是以 little-endian 顺序存储音频数据。
    boolean bigEndian = false;
    // 构造具有线性 PCM 编码和给定参数的 AudioFormat。
    return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
  }
}
