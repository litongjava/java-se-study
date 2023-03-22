package com.litongjava.commonsjexl;

import java.util.Map;

import org.apache.commons.jexl2.Expression;
import org.apache.commons.jexl2.JexlContext;
import org.apache.commons.jexl2.JexlEngine;
import org.apache.commons.jexl2.MapContext;

/**
 * @author Administrator
 * @date 2019年1月8日_下午5:57:39 
 * @version 1.0 
 */
public class JexlUtil {
  private JexlEngine jexlEngine;

  public JexlUtil() {
    jexlEngine = new JexlEngine();
  }

  public Object execMethod(String exp, Map<String, Object> map) {
    Expression expression = jexlEngine.createExpression(exp);
    JexlContext context = new MapContext();
    if (map != null) {
      for (Map.Entry<String, Object> e : map.entrySet()) {
        context.set(e.getKey(), e.getValue());
      }
    }
    Object evaluate = expression.evaluate(context);
    return evaluate;
  }
}
