package 语雀学习.新特性.Lambda表达式;


import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/6 20:17
 */

public class LambdaTest {

    @Test
    public void testClosure() throws InterruptedException{
        // 在匿名内部类的外面定义一个String变量
        final String str = "hello";
/*
        // 构造一个匿名内部类对象
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(str);
                System.out.println("this===>"+ this);
            }
        };
*/


        Runnable r = () -> {
            System.out.println(str);
            System.out.println("this===>" + this);
        };
        new Thread(r).start();

        TimeUnit.SECONDS.sleep(1);
    }


    @Test
    public void testClosure1() throws InterruptedException{
        String str = "hello";
    }




}
