package 语雀学习.基础进阶.注解;

import 语雀学习.基础进阶.注解.Anno.MyAnnotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射获取注解信息
 */
public class AnnotationTest {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {

        //获取类上的注解
        Class<Demo> clazz = Demo.class;
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.getValue());

        //获取成员变量上的注解
        Field name = clazz.getField("name");
        MyAnnotation annotationOnField = name.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnField.getValue());

        //获取hello方法上的注解
        Method hello = clazz.getMethod("hello", (Class<?>[]) null);
        MyAnnotation annotationOnMethod = hello.getAnnotation(MyAnnotation.class);
        System.out.println(annotationOnMethod.getValue());

        //获取defaultMethod方法上的注解
        Method defaultMethod = clazz.getMethod("defaultMethod", (Class<?>[]) null);
        MyAnnotation annotation1 = defaultMethod.getAnnotation(MyAnnotation.class);
        System.out.println(annotation1.getValue());
    }
}
