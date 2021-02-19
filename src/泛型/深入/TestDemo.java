package 泛型.深入;

import org.junit.Test;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class TestDemo {

    /**
     * 原始类型相等
     */
    @Test
    public void Test1(){
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("abc");

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);

        System.out.println(list1.getClass() == list2.getClass());//true
    }

    /**
     * 通过反射添加其他类型元素
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    @Test
    public void Test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1);
        list.getClass().getMethod("add",Object.class).invoke(list,"asd");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 调用泛型方法
     */
    @Test
    public void Test3(){

        //不指定泛型时
        int i = TestDemo.add(1,2);//都是Integer，所以T为Integer类型
        Number f = TestDemo.add(1,1.2);//一个是Integer，一个是Float，所以取同一父类最小级，Number
        Object o = TestDemo.add(1,"asd");//一个Integer，一个String，取最小级,Object

        //指定泛型时
        int a = TestDemo.<Integer>add(1,2);//指定了Integer，所以只能为Integer 或者 子类
//        int b = TestDemo.<Integer>add(1,2.2);//编译报错，指定了Integer，不能为Float
        Number c = TestDemo.<Number>add(1,2.2);//指定为Number，所以可以为Integer和Float

    }

    //一个简单的泛型方法
    public static <T> T add(T x,T y){
        return y;
    }

    @Test
    public void Test4(){
        ArrayList list = new ArrayList();
        list.add(1);
        list.add("123");
        list.add(new Date());
        for (Object o : list) {
            System.out.println(o);
        }
    }

    /**
     * Java编译器是通过先检查代码中泛型的类型，然后在进行类型擦除，再进行编译。
     */
    @Test
    public void Test5(){
        ArrayList<String> list1 = new ArrayList<>();//引用 使用了泛型
        list1.add("1");
//        list1.add(1);//编译报错
        String str1 = list1.get(0);//返回类型就是String

        ArrayList list2 = new ArrayList<String>();//引用 没有使用泛型
        list2.add("1");
        list2.add(2);
        Object o = list2.get(0);

        new ArrayList<String>().add("11");
//        new ArrayList<String>().add(22);//编译报错

        String str2 = new ArrayList<String>().get(0);
    }
}
