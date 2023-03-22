package com.litongjava.swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Ping E Lee
 *
 */
@Slf4j
public class MyKeyListener implements KeyListener {

  @Override
  public void keyPressed(KeyEvent e) {
    // 获取按下的键
    // 获取按键,使用getKeyChar()获取不到F1->F12
    // char keyChar = e.getKeyChar();
    // log.info("keyChar:{}", keyChar);
    int keyCode = e.getKeyCode();
    log.info("keyCode:{}", keyCode);
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

}
