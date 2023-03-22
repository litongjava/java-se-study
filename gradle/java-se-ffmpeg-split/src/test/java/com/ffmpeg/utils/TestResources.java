package com.ffmpeg.utils;

import static org.junit.Assert.fail;

import java.net.URL;

import org.junit.Test;

/**
 * @author litong
 * @date 2018年4月7日
 * getClassLoader().getResource()
 * 要吗返回真是路径,要吗返回null
 *
 */
public class TestResources {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test1() {
		URL resource = this.getClass().getClassLoader().getResource("/");
		System.out.println(resource);//==>null
	}
	
	@Test
	public void test2() {
		URL resource = this.getClass().getClassLoader().getResource("com\ffmpeg\ffepmg\ffmpeg.exe");
		System.out.println(resource);//==>null
		String file = resource.getFile();
		System.out.println(file);//==> null
		
	}
	
	@Test
	public void test3() {
		URL resource = TestResources.class.getClassLoader().getResource("config.properties");
		System.out.println(resource);
		//if exists config.propertes then return file:/D:/dev_workspace/java/study/se-ffmpeg-split/bin/config.properties
		//else return null
//		String ffmpegProgram="com\\ffmpeg\\ffepmg\\ffmpeg.exe";
		String ffmpegProgram="com/ffmpeg/ffepmg/ffmpeg.exe";
		URL ffpmegPath = TestResources.class.getClassLoader().getResource(ffmpegProgram);
		System.out.println(ffmpegProgram);
	}
	
	@Test
	public void test4() {
		String ffmpegProgram="com/ffmpeg/ffepmg/ffmpeg.exe";
		URL resource = TestResources.class.getClassLoader().getResource(ffmpegProgram);
		System.out.println(resource);//==>file:/D:/dev_workspace/java/study/se-ffmpeg-split/bin/com/ffmpeg/ffepmg/ffmpeg.exe
	}

}
