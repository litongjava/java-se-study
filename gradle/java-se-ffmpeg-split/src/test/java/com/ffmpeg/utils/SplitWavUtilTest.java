package com.ffmpeg.utils;

import static org.junit.Assert.fail;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ffmpeg.model.ParamWavSplitInfo;

public class SplitWavUtilTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	/**
	 * 1-2.wav 文件名不能已经存在
	 */
	@Test
	public void testSplit() {
		// force-硅基客户-360-00_00_56-00_00_09.wav
		String filePath = "D:\\dev_ideaProjects\\smart-ivr\\smart-ivr-payment\\src\\main\\resources\\public\\scene1\\force-硅基客户-360-00_01_03-00_00_02.wav";
		String start = "00:00:00.500";
		String end = "00:00:02.500";
		SplitWavUtil.split(filePath, start, end, "force-硅基客户-360-00_56_06-00_00_07.wav");

	}

	@Test
	public void testSplit2() {
		String filePath = "D:\\dev_ideaProjects\\smart-ivr\\smart-ivr-payment\\src\\main\\resources\\public\\scene1\\force-硅基客户-360-00_00_56-00_00_07.wav";
		String start = "00:00:00";
		String length = "00:00:06.500";
		String content = "那,谢谢你的匹配合,那好的,再见";
		String split = SplitWavUtil.split(filePath, start, length, true, content);
		System.out.println(split);
	}

	/**
	 * use list as paramater
	 */
	@Test
	public void testSplit3() {
		String filePath = "D:\\dev_workspace\\java\\study\\se-ffmpeg-split\\src\\main\\resources\\wav\\force-硅基客户-360.wav";
		List<ParamWavSplitInfo> list = new ArrayList<>();
		list.add(new ParamWavSplitInfo(filePath, "00:00:09", "00:00:03", "坐席:哎,你好,请问是 林志玲 吗? 09-11"));
		list.add(new ParamWavSplitInfo(filePath, "00:00:15", "00:00:11",
				"坐席:这边是360借条管理部的,如果你认识林志玲,请转告他,让他及时回电010 5396 5700可以吗, 15-26"));
		list.add(new ParamWavSplitInfo(filePath, "00:00:29", "00:00:08",
				"坐席:你的欠款是1000万元,然后为了避免给你造成不必要的困扰,请你务必在今天足额还清, 29-37"));
		list.add(new ParamWavSplitInfo(filePath, "00:00:40", "00:00:12",
				"坐席:你有在我们公司是有办理过贷款,然后给你打电话就是提醒你该按时还款了,如果你这边有任何疑问的话,可以联系010-5390 5700沟通一下可以吗 39-51"));
		list.add(new ParamWavSplitInfo(filePath, "00:00:56", "00:00:09",
				"坐席: 这个贷款逾期的话,对于欠款人生活还有工作的影响还蛮多的哈,所以请你这边一定要及时转告,那谢谢你的配合,好的,再见 55-1:06"));
		SplitWavUtil.moreSplit(list);
	}

	@Test
	public void testFileExists() {
		String filePath = "file:/D:/dev_workspace/java/study/se-ffmpeg-split/bin/com/ffmpeg/ffepmg/ffmpeg.exe";
		File file = new File(filePath);
		System.out.println(file.exists());
	}

}
