package com.litongjava.reflex;
/**
 * @author litong
 * @date 2018年6月6日_下午5:54:57 
 * @version 1.0 
 */
public class FactoryImpl implements Factory {
	
	public Factory newInstance() {
		return new FactoryImpl();
	}

}
