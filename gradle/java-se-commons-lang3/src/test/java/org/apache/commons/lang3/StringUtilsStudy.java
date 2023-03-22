package org.apache.commons.lang3;

import org.junit.Test;

/**
 * @author litong
 * @date 2018��4��11��
 *
 */
public class StringUtilsStudy {
	@Test
	public void isEmptyTest() {
		//ֻ�е���null������"" ����true����������·���false
		boolean empty = StringUtils.isEmpty(null);
		System.out.println(empty);
		empty = StringUtils.isEmpty("");
		System.out.println(empty);
		empty=StringUtils.isEmpty(" ");
		System.out.println(empty);
	}
	
	@Test
	public void idNotEmptyTest() {
		//����null��""������false����������·���true
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
