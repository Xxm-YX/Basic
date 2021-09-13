package 语雀学习.新特性.山寨StreamAPI设计分析;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MockStream {

    public static void main(String[] args) throws JsonProcessingException {
        MyList<Person> personMyList = new MyList<>();
        personMyList.add(new Person("李健", 46));
        personMyList.add(new Person("周深", 28));
        personMyList.add(new Person("张学友", 59));

        //过度1：把Lambda赋值给变量
        MyList.Predicate<Person> predicate = person -> person.getAge() > 40;
        MyList<Person> filter = personMyList.filter(predicate);
        prettyPrint(filter);

        System.out.println("\n---------------------------------------------\n");


        MyList<Person> filter1 = personMyList.filter(person -> person.getAge() > 40);
        prettyPrint(filter1);

        System.out.println("\n---------------------------------------------\n");

        //请真正的StreamAPI

        List<Person> list = new ArrayList<>();
        list.add(new Person("李健", 46));
        list.add(new Person("周深", 28));
        list.add(new Person("张学友", 59));

        List<Person> collect = list.stream().filter(person -> person.getAge() > 40).collect(Collectors.toList());
        prettyPrint(collect);

        System.out.println("\n---------------------------------------------\n");

        Person bravo = new Person("bravo", 18);

        //1.具体实现类，Function<Person,Integer>中，Person是入参类型，Integer是转换类型
        MyList.Function<Person,Integer> function1 = new MyList.FunctionImpl();
        Integer age = function1.apply(bravo);
        myPrint(bravo,function1);


        //2.匿名类
        MyList.Function<Person,Integer> function2 = new MyList.Function<Person, Integer>() {
            @Override
            public Integer apply(Person person) {
                return person.getAge();
            }
        };
        myPrint(bravo,function2);


        //3.lambda表达式，person（入参类型）->person.getAge() 返回值类型
        MyList.Function<Person,Integer> function3 = person -> person.getAge();
        myPrint(bravo,function3);
    }
    public static void myPrint(Person person, MyList.Function<Person, Integer> mapper) {
        System.out.println(mapper.apply(person));
    }
    /**
     * 按JSON格式输出
     *
     * @param obj
     * @throws
     */
    private static void prettyPrint(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        System.out.println(s);
    }
}

@Data
@AllArgsConstructor
class Person {
    private String name;
    private Integer age;
}


@Getter
class MyList<T> {
    private List<T> list = new ArrayList<>();

    public boolean add(T t){
        return list.add(t);
    }

    /**
     * 给MyList传递具体的判断规则，然后MyList把内部现有符合判断(true)的元素返回
     * @param predicate
     * @return
     */
    public MyList<T> filter(Predicate<T> predicate){
        MyList<T> filteredList = new MyList<>();
        for (T t : list) {
            if(predicate.test(t)){
                //收集判断为true的元素
                filteredList.add(t);
            }
        }
        return filteredList;
    }

    /**
     * 把MyList中的List<T>转换成List<R>
     * @param mapper
     * @param <R>
     * @return
     */
    public <R> MyList<R> map(Function<T,R> mapper){
        MyList<R> mappedList = new MyList<>();
        for (T t : list) {
            mappedList.add(mapper.apply(t));
        }
        return mappedList;
    }

    /**
     * 定义一个Predicate接口，名字无所谓
     *
     * @param <T>
     */
    @FunctionalInterface
    interface Predicate<T> {
        /**
         * 定义了一个test()方法，传入任意对象，返回true or false，具体判断逻辑由子类实现
         *
         * @param t
         * @return
         */
        boolean test(T t);
    }


    /**
     * 定义一个Function接口，名字无所谓
     *
     * @param <E>
     * @param <R>
     */

    @FunctionalInterface
    interface Function<E, R> {
        /**
         * 定义一个apply()方法，接收一个E返回一个R。也就是把E映射成R
         *
         * @param e
         * @return
         */
        R apply(E e);
    }

    /**
     * Function接口的实现类，规定传入Person类型 返回 Integer类型
     */
    static class FunctionImpl implements Function<Person,Integer>{

        /**
         * 传入person对象，返回age
         * @param person
         * @return
         */
        @Override
        public Integer apply(Person person) {
            return person.getAge();
        }
    }
}