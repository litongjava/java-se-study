package com.interfaces;

/**
 * @author litong
 * @date 2018年10月5日_下午10:25:13 
 * @version 1.0 
 */
public interface Output {

  int MAX_CACHE_LINE = 50;

  public void getData(String msg);

  public void out();
}
