package com.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testConstract() {
		User user = new User();
		System.out.println(user);
	}
	
	@Test
	public void userToJson() {
		User user = new User();
		user.setUsername("litong");
		user.setPassword("litong123");
		ObjectMapper om = new ObjectMapper();
		String userStrJson=null;
		try {
			userStrJson = om.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(userStrJson);
	}
	
	@Test
	public void jsonToUser() {
		String userStrJson="{\"username\":\"litong\",\"password\":\"litong123\"}";
		ObjectMapper om = new ObjectMapper();
		try {
			User readValue = om.readValue(userStrJson, User.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
