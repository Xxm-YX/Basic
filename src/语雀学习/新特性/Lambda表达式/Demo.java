package 语雀学习.新特性.Lambda表达式;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/6 19:41
 */
public class Demo {

    public static void main(String[] args) {
        //new 一个MyThread对象，调用start（）

       /* ByTrain byTrain = new ByTrain();
        new MyThread(byTrain).start();

        ByAir byAir = new ByAir();
        new MyThread(byAir).start();*/
/*
        //匿名内部类
        new MyThread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println("不用买票");
                System.out.println("骑电瓶车...");
            }
        }).start();

        //lambda表达式
        new MyThread(() -> {
            System.out.println("不用买票");
            System.out.println("骑电瓶车...");
        }).start();

        */
//        new MyThread( () -> System.out.println("哈哈")).start();

        String str1 = "abc";
        String str2 = "abcd";

        int i = compareString(str1, str2, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });


        //lambda表达式等价用法
        Comparator<String> comparator = (String s1,String s2) -> {
            return s1.length() - s2.length();
        };

        compareString(str1,str2,(String s1,String s2) -> {
            return s1.length() - s2.length();
        });

        compareString(str1,str2,(s1,s2) -> s1.length() - s2.length());

        //完美
        compareString(str1,str2,Comparator.comparingInt(String::length));

        //调用，类似于传入一个方法进去
        int k = compareString(str1,str2,comparator);


        // 原始数据
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3));
        //filter()方法需要传入一个过滤逻辑
        List<Integer> result = list.stream().filter(value -> value >2).collect(Collectors.toList());
        System.out.println(result);
    }




    public static int compareString(String str1, String str2, Comparator<String> comparator){
        return comparator.compare(str1,str2);
    }
}
