package com.interfaces;

/**
 * @author litong
 * @date 2018年10月6日_上午10:45:26 
 * @version 1.0 
 */
public class OutputFactory {
  public Output getOutput() {
    return new BetterPrint();
  }

  public static void main(String[] args) {
    OutputFactory of = new OutputFactory();
    Computer c = new Computer(of.getOutput());
    c.keyIn("java");
    c.keyIn("c");
    c.print();
  }
}