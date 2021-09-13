package 语雀学习.新特性.StreamAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest4 {

    private static List<Person> list;

    static {
        list = new ArrayList<>();
        list.add(new Person("i", 18, "杭州", 999.9));
        list.add(new Person("am", 19, "温州", 777.7));
        list.add(new Person("iron", 21, "杭州", 888.8));
        list.add(new Person("iron", 17, "宁波", 888.8));
    }

    public static void main(String[] args) {
//        Map<String, Person> nameToPersonMap = list.stream().collect(Collectors.toMap(Person::getName, person -> person));

        Map<String, Person> nameToPersonMap = list.stream()
                .collect(Collectors.toMap(Person::getName, person -> person, (preKey, nextKey) -> preKey));

        Map<String, Person> nameToPersonMap2 = list.stream()
                .collect(Collectors.toMap(Person::getName, Function.identity()));

        System.out.println(nameToPersonMap);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Person {
        private String name;
        private Integer age;
        private String address;
        private Double salary;

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", address='" + address + '\'' +
                    ", salary=" + salary +
                    '}';
        }
    }
}
