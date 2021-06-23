//package com.annotation;
//
//import java.util.LinkedHashSet;
//import java.util.Set;
//
//import javax.annotation.processing.AbstractProcessor;
//import javax.annotation.processing.ProcessingEnvironment;
//import javax.annotation.processing.RoundEnvironment;
//import javax.lang.model.element.TypeElement;
//
///**
// * @author litong
// * @date 2018年7月24日_下午8:04:51 
// * @version 1.0 
// */
//public class XXProcessor/* extends AbstractProcessor */ {
//  private ProcessingEnvironment envir;
//
//  public XXProcessor(ProcessingEnvironment env) {
//    this.envir = env;
//  }
//
//  @Override
//  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
//    for (TypeElement typeEle : annotations) {
//      System.out.println(typeEle);
//      // NullValueValidate annotation = typeEle.getAnnotation(NullValueValidate
//      // .class);
//
//      // if (annotation == null)
//      // break;
//      //
//      // Class clazz = typeEle.getClass();
//      // if (clazz.getDeclaredMethods().length > 0) {
//      // try {
//      // if (typeEle.getModifiers().contains(Modifier.PUBLIC) &&
//      // !typeEle.getModifiers().contains(Modifier.STATIC)) {
//      // PrintWriter writer = (PrintWriter)
//      // envir.getFiler().createSourceFile(wondertwoInterface.value());
//      // writer.println("package " + clazz.getPackage().getName() + ";");
//      // writer.println("public interface " + wondertwoInterface.value() + " {");
//      // for (Method method : clazz.getDeclaredMethods()) {
//      // writer.print(" public ");
//      // writer.print(method.getReturnType() + " ");
//      // writer.print(method.getName() + " (");
//      // int i = 0;
//      // for (TypeParameterElement parameter : typeEle.getTypeParameters()) {
//      // writer.print(parameter.asType() + " " + parameter.getSimpleName());
//      // if (++i < typeEle.getTypeParameters().size())
//      // writer.print(", ");
//      // }
//      // writer.println(");");
//      // }
//      // writer.println("}");
//      // writer.close();
//      // }
//      // } catch (IOException e) {
//      // throw new RuntimeException(e);
//      // }
//      // }
//    }
//    return true;
//  }
//
//  @Override
//  public Set<String> getSupportedAnnotationTypes() {
//    Set<String> types = new LinkedHashSet<>();
//    types.add(NullValueValidate.class.getCanonicalName());
//    return types;
//  }
//
//}
