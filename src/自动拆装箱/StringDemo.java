package 自动拆装箱;

import org.junit.Test;

public class StringDemo {

    @Test
    public void test(){
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        String s3 = s1.intern();

        System.out.println(s1 == s2);//false
        System.out.println(s2.intern() == s3);//true
        System.out.println(s3 == s1);//false

        System.out.println("==============");
        String s4 = "bbb";
        String s5 = "bbb";
        System.out.println(s4 == s5);//true
    }

    @Test
    public void test2(){
        float f = 1.1f;
        System.out.println(f);
    }

    @Test
    public void test3(){
        String a = "hello world";
        String replace = a.replace('o', 'w');
        System.out.println(replace);
    }
}
