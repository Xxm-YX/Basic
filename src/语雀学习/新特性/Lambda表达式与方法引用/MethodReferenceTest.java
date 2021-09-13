package 语雀学习.新特性.Lambda表达式与方法引用;

import lombok.AllArgsConstructor;
import lombok.Data;
import 语雀学习.新特性.Lambda表达式.Person;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest {

    private static final List<Person> list;

    static {
        list = new ArrayList<>();
        list.add(new Person(19));
        list.add(new Person(18));
        list.add(new Person(20));
    }

    public static void main(String[] args) {
        System.out.println(list);
        //sort()方法是list本身就有的，主要用来排序
//        list.sort((p1,p2) -> p1.getAge() - p2.getAge());
        // 改动2：既然Person内部有个逻辑一样的方法，就用它来替换Lambda
        list.sort(Person::compare);
        System.out.println(list);
    }

    @Data
    @AllArgsConstructor
    static class Person {
        private Integer age;

        public static int compare(Person p1,Person p2){
            return p1.getAge() - p2.getAge();
        }
    }
}
