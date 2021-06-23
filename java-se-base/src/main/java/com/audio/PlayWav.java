package com.audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author litong
 * @date 2018年8月7日_上午9:12:26 
 * @version 1.0 
 */
public class PlayWav {

  private static final Logger log = LoggerFactory.getLogger(PlayWav.class);

  public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
    String wavPath = "C:\\Users\\Administrator\\Desktop\\wav\\小A地产录音.wav";
    File wavFile = new File(wavPath);
    System.out.println("wav file size:" + wavFile.length() + "byte");
    int sampleCount = (int) ((wavFile.length() - 44) / 2);
    log.info("sampleCount is : " + sampleCount);
    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(wavFile);
    long frameLength = audioInputStream.getFrameLength();
    System.out.println(frameLength);// ==>1329886
    AudioFormat format = audioInputStream.getFormat();
    float frameRate = format.getFrameRate();
    log.info("frameRate is : " + frameRate);
    int frameSize = format.getFrameSize();
    log.info("frameSize is : " + frameSize);
    float sampleRate = format.getSampleRate();
    log.info("sampleRate is : " + sampleRate);
  }
}
