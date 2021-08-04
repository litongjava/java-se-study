package com.commonsjexl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

import com.echo.Echo;

/**
 * @author Administrator
 * @date 2019年1月8日_下午5:36:25 
 * @version 1.0 
 */
public class CommonsJexlStudy {
  public static void main(String[] args) {
    CommonsJexlStudy commonsJexlStudy = new CommonsJexlStudy();
    commonsJexlStudy.study3();
  }

  public void study1() {
    // 创建jexlEngine
    JexlEngine jexlEngine = new JexlEngine();
    // 创建一个 Expression
    String jexlExpression = "echo.echo(str)";
    Expression expression = jexlEngine.createExpression(jexlExpression);
    // 创建Context并且添加数据
    JexlContext jexlContext = new MapContext();
    jexlContext.set("echo", new Echo());
    jexlContext.set("str", "litong");
    // 执行表达式获取结果
    Object evaluate = expression.evaluate(jexlContext);
    System.out.println(evaluate);
  }

  public void study2() {
    String exp = "System.out.println(\"litong\")";
    JexlUtil jexlUtil = new JexlUtil();
    Object execMethod = jexlUtil.execMethod(exp, null);
    System.out.println(execMethod);
  }

  public void study3() {
    String exp = "money>=2000&&money<=4000";
    Map<String, Object> data = new HashMap<>();
    data.put("money", 3000);
    JexlUtil jexlUtil = new JexlUtil();
    Object result = jexlUtil.execMethod(exp, data);
    System.out.println(result);
  }
}
