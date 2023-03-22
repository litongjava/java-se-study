package com.runtime.utils;

import static org.junit.Assert.*;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuntimeTest {
	
	private static final Logger log = LoggerFactory.getLogger(RuntimeTest.class);

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void test1() {
		try {
			Process exec = Runtime.getRuntime().exec("notepad.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getOutput() {
		System.out.println("");
		Process exec=null;
		try {
			exec = Runtime.getRuntime().exec(new String[]{"cmd","/c","dir"});
			exec.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//获取命令执行结果
		InputStream ins = exec.getInputStream();
		BufferedReader buf = new BufferedReader(new InputStreamReader(ins));
		String line=null;
		try {
			while((line=buf.readLine())!=null) {
				log.info("line is : " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
		
	}

}
