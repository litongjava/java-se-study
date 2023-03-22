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
	 * 1-2.wav �ļ��������Ѿ�����
	 */
	@Test
	public void testSplit() {
		// force-����ͻ�-360-00_00_56-00_00_09.wav
		String filePath = "D:\\dev_ideaProjects\\smart-ivr\\smart-ivr-payment\\src\\main\\resources\\public\\scene1\\force-����ͻ�-360-00_01_03-00_00_02.wav";
		String start = "00:00:00.500";
		String end = "00:00:02.500";
		SplitWavUtil.split(filePath, start, end, "force-����ͻ�-360-00_56_06-00_00_07.wav");

	}

	@Test
	public void testSplit2() {
		String filePath = "D:\\dev_ideaProjects\\smart-ivr\\smart-ivr-payment\\src\\main\\resources\\public\\scene1\\force-����ͻ�-360-00_00_56-00_00_07.wav";
		String start = "00:00:00";
		String length = "00:00:06.500";
		String content = "��,лл���ƥ���,�Ǻõ�,�ټ�";
		String split = SplitWavUtil.split(filePath, start, length, true, content);
		System.out.println(split);
	}

	/**
	 * use list as paramater
	 */
	@Test
	public void testSplit3() {
		String filePath = "D:\\dev_workspace\\java\\study\\se-ffmpeg-split\\src\\main\\resources\\wav\\force-����ͻ�-360.wav";
		List<ParamWavSplitInfo> list = new ArrayList<>();
		list.add(new ParamWavSplitInfo(filePath, "00:00:09", "00:00:03", "��ϯ:��,���,������ ��־�� ��? 09-11"));
		list.add(new ParamWavSplitInfo(filePath, "00:00:15", "00:00:11",
				"��ϯ:�����360����������,�������ʶ��־��,��ת����,������ʱ�ص�010 5396 5700������, 15-26"));
		list.add(new ParamWavSplitInfo(filePath, "00:00:29", "00:00:08",
				"��ϯ:���Ƿ����1000��Ԫ,Ȼ��Ϊ�˱��������ɲ���Ҫ������,��������ڽ�������, 29-37"));
		list.add(new ParamWavSplitInfo(filePath, "00:00:40", "00:00:12",
				"��ϯ:���������ǹ�˾���а��������,Ȼ������绰����������ð�ʱ������,�����������κ����ʵĻ�,������ϵ010-5390 5700��ͨһ�¿����� 39-51"));
		list.add(new ParamWavSplitInfo(filePath, "00:00:56", "00:00:09",
				"��ϯ: ����������ڵĻ�,����Ƿ��������й�����Ӱ�컹����Ĺ�,�����������һ��Ҫ��ʱת��,��лл������,�õ�,�ټ� 55-1:06"));
		SplitWavUtil.moreSplit(list);
	}

	@Test
	public void testFileExists() {
		String filePath = "file:/D:/dev_workspace/java/study/se-ffmpeg-split/bin/com/ffmpeg/ffepmg/ffmpeg.exe";
		File file = new File(filePath);
		System.out.println(file.exists());
	}

}
