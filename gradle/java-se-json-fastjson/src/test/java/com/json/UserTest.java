package com.json;

import static org.junit.Assert.*;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

/**
 * @author litong
 * @date 2018年4月14日_上午12:07:29 
 * @version 1.0 
 */
public class UserTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**
	 * 使用fastjson将pojo转换为json
	 */
	@Test
	public void pojoToJsonTest() {
		User user = new User("litong","litong1234");
		String jsonString = JSON.toJSONString(user);
		System.out.println(jsonString);
	}
}
