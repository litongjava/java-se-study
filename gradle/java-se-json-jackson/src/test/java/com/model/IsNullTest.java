package com.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IsNullTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	/**
	 * test sucdess
	 * {"b",false}
	 */
	@Test
	public void testBooleanStr() {
		IsNull isNull = new IsNull();
		ObjectMapper om = new ObjectMapper();
		String isNullStrJson=null;
		try {
			isNullStrJson = om.writeValueAsString(isNull);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(isNullStrJson);
	}

}
