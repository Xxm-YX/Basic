package 语雀学习.基础进阶.注解.Anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Lenovo
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String getValue() default "no description";
}
