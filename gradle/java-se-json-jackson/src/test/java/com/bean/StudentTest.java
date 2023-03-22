package com.bean;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentTest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void test1() throws JsonProcessingException {
		Person person = new Person();
		person.setUsernmae("litong");
		ObjectMapper objectMapper = new ObjectMapper();
		String personJsonStr = objectMapper.writeValueAsString(person);
		System.out.println(personJsonStr);
	}
	
	@Test
	public void test2() throws JsonProcessingException {
		Student student = new Student();
		student.setUsernmae("litong");
		student.setPassword("litong123");
		ObjectMapper objectMapper = new ObjectMapper();
		String studentJsonStr = objectMapper.writeValueAsString(student);
		System.out.println(studentJsonStr);
	}
	
	@Test
	public void test3() throws JsonProcessingException {
		Student student = new Student();
		student.setUsernmae("litong");
		student.setPassword("litong123");
		Person p=(Person)student;
		ObjectMapper objectMapper = new ObjectMapper();
		String personJsonStr = objectMapper.writeValueAsString(p);
		System.out.println(personJsonStr);
	}

}
