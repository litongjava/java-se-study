package com.json;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * @author litong
 * @date 2018��4��14��_����12:07:29 
 * @version 1.0 
 */
public class UserTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**
	 * ʹ��fastjson��pojoת��Ϊjson
	 */
	@Test
	public void pojoToJsonTest() {
		User user = new User("litong","litong1234");
		String jsonString = JSON.toJSONString(user);
		System.out.println(jsonString);
	}
}
