package com.runtime.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author litong
 * @date 2018��4��8��
 *
 */
public class RuntimeUtil {

	private static final Logger log = LoggerFactory.getLogger(RuntimeUtil.class);
	private static Runtime runtime = Runtime.getRuntime();
	public static void getMemoryInfo() {
		// ��ȡʣ���ڴ�
		long freeMemory = runtime.freeMemory();
		log.info("freeMemory is : " + freeMemory / 1024 / 1024 + "mb");
		// ��ȡȫ���ڴ�
		long totalMemory = runtime.totalMemory();
		log.info("totalMemory is : " + totalMemory / 1024 / 1024 + "mb");
		// ��ȡ����ڴ�
		long maxMemory = runtime.maxMemory();
		log.info("maxMemory is : " + maxMemory / 1024 / 1024 + "mb");
	}
	
	public static int getAvaliableProcess() {
		int cores = runtime.availableProcessors();
		log.info("cores is : " + cores);
		return cores;
	}
}
