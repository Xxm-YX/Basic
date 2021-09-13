package 语雀学习.新特性.StreamAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    private static List<Person> list;

    static {
        list = new ArrayList<>();
        list.add(new Person("甲", 18, "杭州", 999.9));
        list.add(new Person("乙", 19, "温州", 777.7));
        list.add(new Person("丙", 21, "杭州", 888.8));
        list.add(new Person("丁", 17, "宁波", 888.8));

    }

    public static void main(String[] args) {
        List<Person> collect = list.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.toList());


        //先学中间操作

        //1.获取流 （不用管其他乱七八糟的创建方式，记住一个就能应付95的场景）
        Stream<Person> stream = list.stream();
        //2.过滤年纪大于18岁的
        Stream<Person> filteredByAgeStream  = stream.filter(person -> person.getAge() > 18);
        //3.只要名字，不要整个Person对象，（为什么在这个案例中，filter只能用Lambda，map却可以用方法引用？）
        Stream<String> nameStream = filteredByAgeStream.map(Person::getName);
        //4.现在返回值是Stream<String>,没法直接使用，帮我收集成List<String>
        List<String> collect1 = nameStream.collect(Collectors.toList());

        //现在还对collect（）为什么传递Collectors.toList()感到蒙吗


        List<String> collect2 = list.stream()
                .filter(person -> person.getAge() > 18)
                .map(Person::getName)
                .collect(Collectors.toList());


        //JDK8 之前 Collections工具类+匿名内部类，Collections类似于Arrays工具类
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });

        //JDK8之前，List本身也实现了sort()
        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });

        //JDK8 之后：Lambda传参给Comparator接口，其实就是实现了Comparator#compare()
        //注意 equals()是Object的，不妨碍。
        list.sort(Comparator.comparingInt(p -> p.getName().length()));


    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person{
        private String name;
        private Integer age;
        private String address;
        private Double salary;
    }



    @Test
    public void test(){
        System.out.println(System.currentTimeMillis());
    }
}
