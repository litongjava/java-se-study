package com.ffmpeg.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ffmpeg.constant.FfmpegInfo;
import com.ffmpeg.model.ParamWavSplitInfo;

/**
 * @author litong
 * @date 2018��4��7�� ���wav�ļ��Ĺ�����
 * @cmd ffmpeg -i source_mp3.mp3 -ss 00:01:12 -t 00:01:42 -acodec copy output_mp3.mp3
 *      
 */
public class SplitWavUtil {

	private static final Logger log = LoggerFactory.getLogger(SplitWavUtil.class);

	/**
	 * �����Ƶ�ļ�
	 * 
	 * @param sourceFile
	 * @param startTime
	 * @param length
	 * @param toFile
	 */
	public static void split(String sourceFile, String startTime, String length, String toFile) {
		URL ffmpegPathUrl = SplitWavUtil.class.getClassLoader().getResource(FfmpegInfo.PATH);
		String prefix = "file:/";
		String ffmpegPath = null;
		if (ffmpegPathUrl.toString().startsWith(prefix)) {
			ffmpegPath = ffmpegPathUrl.toString().substring(prefix.length());
		}
		log.info("ffpmegPath is : " + ffmpegPath);
		// �ж�ffmpeg.exe�Ƿ����
		File ffmpegFile = new File(ffmpegPath.toString());
		if (!ffmpegFile.exists()) {
			try {
				throw new Exception(ffmpegPath.toString() + " file is not found");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String command = ffmpegPath.toString() + " -i " + sourceFile + " -ss " + startTime + " -t " + length
				+ " -acodec copy " + toFile;
		log.info("command is :" + command);
		Process exec = null;
		try {
			exec = Runtime.getRuntime().exec(new String[] { "cmd", "/c", command });
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ��ȡ������ȷִ�н��
		InputStream ins = exec.getInputStream();
		BufferedReader bufReader = new BufferedReader(new InputStreamReader(ins));
		String line = null;
		StringBuffer strBuf = new StringBuffer();
		try {
			while ((line = bufReader.readLine()) != null) {
				strBuf.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufReader != null) {
				try {
					bufReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		log.info("stdout is : " + strBuf.toString());
		// ��ȡ�����������
		InputStream err = exec.getErrorStream();
		bufReader = new BufferedReader(new InputStreamReader(err));
		// clear string buffer
		strBuf = new StringBuffer("");
		try {
			while ((line = bufReader.readLine()) != null) {
				strBuf.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufReader != null) {
				try {
					bufReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		log.info("stderr is : " + strBuf.toString());
	}

	/**
	 * ����ļ�,����toFile
	 * 
	 * @param sourceFile
	 * @param startTime
	 * @param length
	 */
	public static String split(String sourceFile, String startTime, String length) {
		// 1.get filename in absolute path not include extension name
		int dotIndex = sourceFile.lastIndexOf('.');
		// .��չ��
		String extensionName = sourceFile.substring(dotIndex);
		// �ļ���, ·����/���ļ���
		String fileName = sourceFile.substring(0, dotIndex);
		// �µ��ļ���,�ļ����в�������� :
		String startTimeNoColon = startTime.replaceAll(":", "_");
		String lengthNoColon = length.replaceAll(":", "_");
		String retval = fileName + "-" + startTimeNoColon + "-" + lengthNoColon + extensionName;
		SplitWavUtil.split(sourceFile, startTime, length, retval);
		return retval;
	}

	/**
	 * ����ͬ����txt�ļ�,���ļ�,û������
	 * @param sourceFile
	 * @param startTime
	 * @param length
	 * @param creteTxtFile:crete file either true or false
	 * @return
	 */
	public static String split(String sourceFile, String startTime, String length, boolean creteTxtFile) {
		String retval = SplitWavUtil.split(sourceFile, startTime, length);
		String textFileAbsPath = SplitWavUtil.generatorTextFileNmae(retval);
		// cretae text file
		try {
			new File(textFileAbsPath).createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return retval;
	}

	/**
	 * create text file and write content
	 * @param sourceFile
	 * @param startTime
	 * @param length
	 * @param creteTxtFile
	 * @param textContent
	 * @return
	 */
	public static String split(String sourceFile, String startTime, String length, boolean creteTxtFile,
			String textContent) {
		String retval = SplitWavUtil.split(sourceFile, startTime, length);
		String textFileAbsPath = SplitWavUtil.generatorTextFileNmae(retval);
		// cretae text file
		File file = new File(textFileAbsPath);
		BufferedWriter bufWriter = null;
		try {
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			bufWriter = new BufferedWriter(fileWriter);
			// write content to file
			bufWriter.write(textContent);
			bufWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufWriter != null) {
				try {
					bufWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return retval;
	}

	/**
	 * �����ļ���,����·��
	 * @param wavAbsPathName
	 * @return
	 */
	private static String generatorTextFileNmae(String wavAbsPathName) {
		int dotLastIndex = wavAbsPathName.lastIndexOf('.');
		// get absolute name and not include extension name
		String absNameNoIncludeExtension = wavAbsPathName.substring(0, dotLastIndex);
		String textFile = absNameNoIncludeExtension + ".txt";
		return textFile;
	}

	/**
	 * use list as paramater for spalit wavfile
	 * @param params
	 * @return
	 */
	public static Map<String, ParamWavSplitInfo> moreSplit(List<ParamWavSplitInfo> params) {
		Map<String, ParamWavSplitInfo> retval = new HashMap<>();
		for (ParamWavSplitInfo p : params) {
			String wavFile = SplitWavUtil.split(p.getWavFile(), p.getStartTime(), p.getEndTime(), true,
					p.getTextContent());
			retval.put(wavFile, p);
		}
		return retval;
	}
}