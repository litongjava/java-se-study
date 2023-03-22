package com.runtime.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

/**
 * @author litong
 * @date 2018年4月8日
 *
 */
public class CopyFileTest {
	@Test
	public void testCopy() {
		Process exec = null;
		try {
			exec = Runtime.getRuntime().exec(new String[] { "sh", "-c", "cp -r /opt/1/* /op/2/*" });
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 获取输入流
		InputStream ins = exec.getInputStream();
		// 获取错误流
		InputStream err = exec.getErrorStream();

		new Thread() {
			public void run() {
				BufferedReader bufReader = new BufferedReader(new InputStreamReader(ins));
				String line = null;
				try {
					while ((line = bufReader.readLine()) != null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if(bufReader!=null) {
						try {
							bufReader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			};
		}.start();
		
		new Thread() {
			public void run() {
				BufferedReader bufReader = new BufferedReader(new InputStreamReader(err));
				String line=null;
				try {
					while((line=bufReader.readLine())!=null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					if(bufReader!=null) {
						try {
							bufReader.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
						
			};
		}.start();
	}
}