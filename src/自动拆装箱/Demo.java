package 自动拆装箱;

import org.junit.Test;

public class Demo {

    @Test
    public void test1(){
        //创建对象
        Integer x = new Integer(123);
        Integer y = new Integer(123);

        System.out.println(x == y); //false
        System.out.println("==========");
        //缓存池中取对象
        Integer z = Integer.valueOf(123);
        Integer k = Integer.valueOf(123);

        System.out.println(z == k);//true

        System.out.println(x == z);//false
        //赋值
        System.out.println("=========");
        Integer a = 123;//自动装箱
        Integer b = 123;
        System.out.println(a == b);//true
        System.out.println(a == x);//false
        System.out.println(a == z);//true

    }
}
