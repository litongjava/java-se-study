package com.math.test;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author litong
 * @date 2018��4��11��
 *
 */
public class BigDecimalTest {
	@Test
	public void test1() {
		// ���롰0.3�� û�о��ȵ���ʧ���������0.3���о��ȵ���ʧ
		BigDecimal bigDecimal = new BigDecimal("0.3");
		System.out.println(bigDecimal);
	}
}
