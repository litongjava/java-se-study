package org.apache.commons.lang3;

import org.junit.Test;

/**
 * @author litong
 * @date 2018年4月11日
 *
 */
public class StringUtilsStudy {
	@Test
	public void isEmptyTest() {
		//只有当是null或者是"" 返回true，其他情况下返回false
		boolean empty = StringUtils.isEmpty(null);
		System.out.println(empty);
		empty = StringUtils.isEmpty("");
		System.out.println(empty);
		empty=StringUtils.isEmpty(" ");
		System.out.println(empty);
	}
	
	@Test
	public void idNotEmptyTest() {
		//当是null或""，返回false，其他情况下返回true
		boolean notEmpty = StringUtils.isNotEmpty(null);
		System.out.println(notEmpty);
		notEmpty=StringUtils.isNotEmpty("");
		System.out.println(notEmpty);
		notEmpty = StringUtils.isNotEmpty(" ");
		System.out.println(notEmpty);
		
	}
	
	@Test
	public void isBlankTest() {
		boolean blank = StringUtils.isBlank(" ");
		System.out.println(blank);
		blank=StringUtils.isBlank("  ");
		System.out.println(blank);
	}
	@Test
	public void isNotBlankTest() {
		boolean notBlank = StringUtils.isNotBlank(" ");
		System.out.println(notBlank);
		notBlank = StringUtils.isNotBlank("   ");
		System.out.println(notBlank);
	}
	
}
