package com.runtime;

import java.io.IOException;
import java.io.OutputStream;

public class RuntimeHello {
	public static void main(String[] args) {
		Process exec=null;
		try {
			exec = Runtime.getRuntime().exec("dir");
		} catch (IOException e) {
			e.printStackTrace();
		}
		OutputStream out = exec.getOutputStream();
	}
}
