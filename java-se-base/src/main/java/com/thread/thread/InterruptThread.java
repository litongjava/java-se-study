package com.thread.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InterruptThread extends Thread {
	@Override
	public void run() {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String start = sdf.format(new Date());
		System.out.println("线程开始执行:" + start);
		try {
			Thread.sleep(10000); // 休眠10S
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("线程出现异常结束" + sdf.format(new Date()));
		}
	}
}
