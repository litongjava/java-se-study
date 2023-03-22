package com.litongjava.thread.thread;

/**
 * @author litong
 * @date 2018年6月14日_下午11:59:36
 * @version 1.0
 */
public class MyThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(getName() + ":" + i);
		}
	}
}
