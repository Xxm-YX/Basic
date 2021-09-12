package 语雀学习.基础进阶.注解;

import 语雀学习.基础进阶.注解.Anno.MyAnnotation;

@MyAnnotation(getValue = "annotation on class")
public class Demo {

    @MyAnnotation(getValue = "annotation on field")
    public String name;

    @MyAnnotation(getValue = "annotation on method")
    public void hello(){}

    @MyAnnotation() //故意不指定
    public void defaultMethod(){}
}
