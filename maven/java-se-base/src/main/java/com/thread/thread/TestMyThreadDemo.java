package com.thread.thread;

/**
 * @author litong
 * @date 2018年6月15日_上午12:04:05
 * @version 1.0
 */
public class TestMyThreadDemo {
	public static void main(String[] args) {
		TestMyThreadDemo demo = new TestMyThreadDemo();
		// demo.setPriority();
		demo.interrupt();
	}

	/**
	 * 设置线程名称
	 */
	public void setName() {
		// 创建对象
		MyThread thread1 = new MyThread();
		thread1.setName("线程1");
		MyThread thread2 = new MyThread();
		thread2.setName("线程2");
		// 启动线程
		thread1.start();
		thread2.start();
	}

	/**
	 * 设置线程的优先级
	 */
	public void setPriority() {
		// 创建对象
		MyThread thread1 = new MyThread();
		thread1.setName("线程1");
		MyThread thread2 = new MyThread();
		thread2.setName("线程2");
		// 设置优先级
		thread1.setPriority(10);
		thread2.setPriority(4);
		// 启动线程
		thread1.start();
		thread2.start();
	}

	/**
	 * 守护线程
	 */
	public void setDaemon() {
		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		t1.setName("及时雨");
		t2.setName("黑旋风");
		t2.setDaemon(true);
		t1.start();
		t2.start();
	}

	/**
	 * 线程中断
	 */
	public void interrupt() {
		InterruptThread t1 = new InterruptThread();
		t1.start();
		try {
			Thread.sleep(6000);// 我现在休眠6秒，如果6秒run方法里面的东西你还没执行完我就把你中断；
			t1.interrupt();// 这时候run方法没执行完，被中断了所以报了异常，被catch了，所以输出异常信息；
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
