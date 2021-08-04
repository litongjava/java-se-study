package com.audio.recognize;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.iflytek.cloud.speech.RecognizerListener;
import com.iflytek.cloud.speech.RecognizerResult;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechRecognizer;
import com.iflytek.cloud.speech.SpeechUtility;

public class SoundRecodingAndRecognized extends Frame implements ActionListener {
  private static final long serialVersionUID = 1L;
  private static final String APPID = "5a274fb9";
  Button startBtn;
  Button stopBtn;
  TextArea textArea;
  // 语音听写对象
  SpeechRecognizer speechRecognize;
  private static final String DEF_FONT_NAME = "宋体";
  @SuppressWarnings("unused")
  private static final int DEF_FONT_STYLE = Font.BOLD;
  private static final int DEF_FONT_SIZE = 30;
  private static final int TEXT_COUNT = 100;

  public SoundRecodingAndRecognized() {
    // 初始化听写对象
    speechRecognize = SpeechRecognizer.createRecognizer();
    // 设置组件
    startBtn = new Button("start");
    stopBtn = new Button("stop");
    textArea = new TextArea();
    Panel btnPanel = new Panel();
    Panel textPanel = new Panel();
    // Button startBtn = new Button("开始");
    // 添加监听器
    startBtn.addActionListener(this);
    stopBtn.addActionListener(this);
    btnPanel.add(startBtn);
    btnPanel.add(stopBtn);
    textPanel.add(textArea);
    add(btnPanel);
    add(textPanel);
    // 设置窗体
    setLayout(new GridLayout(2, 1));
    setSize(400, 300);
    setTitle("语音识别");
    setLocation(200, 200);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == startBtn) {
      textArea.setText("*************你说的是：");
      if (!speechRecognize.isListening())
        speechRecognize.startListening(recognizerListener);
      else
        speechRecognize.stopListening();
    } else if (e.getSource() == stopBtn) {
      speechRecognize.stopListening();
    }
  }

  /**
   * 听写监听器
   */
  private RecognizerListener recognizerListener = new RecognizerListener() {
    public void onBeginOfSpeech() {
      // DebugLog.Log( "onBeginOfSpeech enter" );
      // ((JLabel) jbtnRecognizer.getComponent(0)).setText("听写中...");
      // jbtnRecognizer.setEnabled(false);
    }

    public void onEndOfSpeech() {
      DebugLog.Log("onEndOfSpeech enter");
    }

    /**
     * 获取听写结果. 获取RecognizerResult类型的识别结果，并对结果进行累加，显示到Area里
     */
    public void onResult(RecognizerResult results, boolean islast) {
      DebugLog.Log("onResult enter");
      String text = results.getResultString();
      textArea.append(text);
      text = textArea.getText();
      if (null != text) {
        int n = text.length() / TEXT_COUNT + 1;
        int fontSize = Math.max(10, DEF_FONT_SIZE - 2 * n);
        DebugLog.Log("onResult new font size=" + fontSize);
        int style = n > 1 ? Font.PLAIN : DEF_FONT_SIZE;
        Font newFont = new Font(DEF_FONT_NAME, style, fontSize);
        textArea.setFont(newFont);
      }
      if (islast) {
        iatSpeechInitUI();
      }
    }

    public void onVolumeChanged(int volume) {
      DebugLog.Log("onVolumeChanged enter");
      if (volume == 0)
        volume = 1;
      else if (volume >= 6)
        volume = 6;
      // labelWav.setIcon(new ImageIcon("res/mic_0" + volume + ".png"));
    }

    public void onError(SpeechError error) {
      DebugLog.Log("onError enter");
      if (null != error) {
        DebugLog.Log("onError Code：" + error.getErrorCode());
        textArea.setText(error.getErrorDescription(true));
        iatSpeechInitUI();
      }
    }

    public void onEvent(int eventType, int arg1, int agr2, String msg) {
      DebugLog.Log("onEvent enter");
    }
  };

  /**
   * 听写结束，恢复初始状态
   */
  public void iatSpeechInitUI() {
    // labelWav.setIcon(new ImageIcon("res/mic_01.png"));
    // jbtnRecognizer.setEnabled(true);
    // ((JLabel) jbtnRecognizer.getComponent(0)).setText("开始听写");
  }

  public static void main(String[] args) {
    SpeechUtility.createUtility("appid=" + APPID);
    SoundRecodingAndRecognized t = new SoundRecodingAndRecognized();
  }
}
