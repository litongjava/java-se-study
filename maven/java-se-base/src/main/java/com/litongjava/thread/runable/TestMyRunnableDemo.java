package com.litongjava.thread.runable;

public class TestMyRunnableDemo {
	public static void main(String[] args) {
		MyRunnable myRunnable = new MyRunnable();
		Thread t1 = new Thread(myRunnable, "线程1");
		Thread t2 = new Thread(myRunnable, "线程2");
		t1.start();
		t2.start();
	}

}
