package com.math.test;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author litong
 * @date 2018年4月11日
 *
 */
public class BigDecimalTest {
	@Test
	public void test1() {
		// 传入“0.3” 没有精度的损失，如果传入0.3会有精度的损失
		BigDecimal bigDecimal = new BigDecimal("0.3");
		System.out.println(bigDecimal);
	}
}
