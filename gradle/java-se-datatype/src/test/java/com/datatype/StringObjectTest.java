package com.datatype;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author litong
 * @date 2018��4��11��_����10:39:02 
 * @version 1.0 
 */
public class StringObjectTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void prefixText() {
		String str1="litong";
		String str2=str1+"1234";
		System.out.println(str2);
		//�ı�str1������
		str1="litong1234";
		System.out.println(str2);
	}
	
	/*
	 * ����equals����
	 */
	@Test
	public void equalsTest() {
		String str=null;
		System.out.println("".equals(str));
		System.out.println("".equals(""));
	}

}
