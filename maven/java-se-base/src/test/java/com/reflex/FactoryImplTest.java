package com.reflex;

import org.junit.Test;

import com.litongjava.reflex.Factory;

/**
 * @author litong
 * @date 2018年6月6日_下午5:57:00 
 * @version 1.0 
 */
public class FactoryImplTest {

	@Test
	public void testNewInstance() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String name = Factory.class.getName();
		System.out.println(name);
		String clazz = System.getProperty(name,name+"Impl");
		System.out.println(clazz);
		Factory factory=(Factory) Class.forName(clazz).newInstance();
	}

}
