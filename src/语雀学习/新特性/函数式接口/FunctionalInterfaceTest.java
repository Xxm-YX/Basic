package 语雀学习.新特性.函数式接口;

import 语雀学习.新特性.Lambda表达式.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalInterfaceTest {

    /**
     * 给函数式接口赋值的格式；
     * 函数时接口  =  入参 -> 出参/制造出参的语句
     */
    public static void main(String[] args) {
        FunctionalInterface1 interface1 = str -> System.out.println(str);
        FunctionalInterface2 interface2 = () -> {
            return "abc";
        };
        FunctionalInterface3 interface3 = str -> Integer.parseInt(str);
        FunctionalInterface4 interface4 = str -> str.length() > 3;


        ArrayList<Person> uncheckPersonList = new ArrayList<>();
        uncheckPersonList.add(new Person("张三", 18));
        uncheckPersonList.add(new Person("李四", 20));

        // 传入Lambda表达式
        /*getHealthPerson(uncheckPersonList, person -> 核酸检测(person));
        getHealthPerson(uncheckPersonList, person -> 胸部CT(person));*/

        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        /**
         * Predicate：特殊映射，只断是非，Function：T t --> f(x) --> boolean
         * Function: 映射                         T t --> f(x) -->R r
         */
       /* list.stream().filter().map().collect(Collectors.toList());

        //Supplier，无源之水（s),却滔滔不绝，没有入参，却可以get（）
        CompletableFuture<Object> completableFuture = CompletableFuture.supplyAsync();

        //Consumer,黑洞 吃(c)葡萄不吐葡萄皮，入参拿过来就是操作，不返回
        completableFuture.thenAccept();*/
    }

    /**
     * 消费型：吃葡萄不吐葡萄皮：有入参，无返回值
     * (T t) -> {}
     */
    interface FunctionalInterface1{
        void method(String str);
    }

    /**
     * 供给型：无中生有，没有入参，却有返回值
     * () -> T t
     */
    interface FunctionalInterface2{
        String method();
    }

    /**
     * 映射型：转换器，把T转换成R返回
     * T t -> R r
     */
    interface FunctionalInterface3{
        int method(String str);
    }

    /**
     * 特殊的映射型：把T 转为boolean
     * T t -> boolean
     */
    interface FunctionalInterface4{
        boolean method(String str);
    }

    /**
     * 用Predicate占坑
     * @param uncheckPersonList
     * @param predicate
     * @return
     */
    public static List<Person> getHealthPerson(List<Person> uncheckPersonList, Predicate<Person> predicate){
        ArrayList<Person> healthyPersonList = new ArrayList<>();

        for (Person person : uncheckPersonList) {
            //占坑，反正需要检测，但是具体拍CT还是核酸检测，具体看情况分析
            if(predicate.test(person)){
                healthyPersonList.add(person);
            }
        }
        return healthyPersonList;
    }
}
