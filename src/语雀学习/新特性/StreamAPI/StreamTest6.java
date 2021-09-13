package 语雀学习.新特性.StreamAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yixuan.zhu
 * @Description //TODO 去重
 * @Date 2021/6/29 18:46
 **/
public class StreamTest6 {

    private static List<Person> list;

    static {
        list = new ArrayList<>();
        list.add(new Person("i", 18, "杭州", 999.9));
        list.add(new Person("am", 19, "温州", 777.7));
        list.add(new Person("iron", 21, "杭州", 888.8));
        list.add(new Person("man", 17, "宁波", 888.8));
    }

    public static void main(String[] args) {
        List<String> collect = list.stream().map(Person::getAddress).distinct().collect(Collectors.toList());
        System.out.println(collect);
        long count = list.stream().map(Person::getAddress).distinct().count();
        System.out.println(count);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Person {
        private String name;
        private Integer age;
        private String address;
        private Double salary;
    }
}
