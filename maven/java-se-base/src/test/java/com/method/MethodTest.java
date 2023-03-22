package com.method;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author litong
 * @date 2018年6月12日_下午7:31:17 
 * @version 1.0 
 */
public class MethodTest {

	@Test
	public void test1() {
		// list的传递是按地址进行传递
		List<String> lists = new ArrayList<>();
		lists.add("a");
		ListAdd.addList(lists);
		// 输出2
		System.out.println(lists.size());
	}

	private static void addList(List<String> lists) {
		lists.add("b");
	}

	@Test
	public void test2() {
		String str = new String("the people's republic of china");
		change(str);
		System.out.println(str);
	}

	private void change(String str) {
		str = "the United States of America";
	}
}
