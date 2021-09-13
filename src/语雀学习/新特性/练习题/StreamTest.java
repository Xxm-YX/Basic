package 语雀学习.新特性.练习题;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    private static List<Person> list;

    static {
        list = new ArrayList<>();
        list.add(new Person("i", 18, "杭州", 999.9));
        list.add(new Person("am", 19, "温州", 777.7));
        list.add(new Person("iron", 21, "杭州", 888.8));
        list.add(new Person("iron", 17, "宁波", 888.8));
    }

    public static void main(String[] args) {
        //获取所有Person的名字
        List<String> personNames = list.stream().map(Person::getName).collect(Collectors.toList());
        System.out.println(personNames);

        //获取一个list，每个元素的内容：{name}来自{address}
        List<String> personNames1 = list.stream()
                .map(person -> person.getName() + "来自" + person.address)
                .collect(Collectors.toList());
        System.out.println(personNames1);

        //过滤出年龄大于等于18的Person
        List<Person> personList = list.stream()
                .filter(person -> person.getAge() >= 18)
                .collect(Collectors.toList());
        System.out.println(personList);

        //过滤出年龄大于等于18 并且 月薪大于等于888.8 并且 来自杭州的Person
        //一般写法：这个filter 完全就是强迫别人花时间从头到尾阅读代码里的细节，毫无提示
        List<Person> personList1 = list.stream()
                .filter(person -> (person.getAge() >= 18 && person.getSalary() > 888.8 && "杭州".equals(person.getAddress())))
                        .collect(Collectors.toList());
        System.out.println(personList);

        //较好的写法：当我们需要给filter（）、map()等函数式接口传递Lambda参数时，
        //逻辑如果很复杂，最好抽取成方法，优先保证可读性
        List<Person> personList2 = list.stream()
                //改为方法引用
                .filter(StreamTest::isRichAdultInHangZhou)
                .collect(Collectors.toList());
        System.out.println(personList2);


        Optional<Person> personMatch = list.stream()
                //经过一些筛选，看看有没有合适的元素
                .filter(person -> "宁波".equals(person.getAddress()))
                .findFirst();
        personMatch.ifPresent(System.out::println);

        // 但有时候你并不关心符合条件的是哪个或哪些元素，只想知道有没有，此时anyMatch()更合适，代码会精炼很多
        boolean exists = list.stream().anyMatch(person -> "宁波".equals(person.getAddress()));

        //list 转 list
        List<String> top2Adult = list.stream()
                .filter(person -> person.getAge() >= 18)          // 过滤得到年龄大于等于18岁的人
                .sorted(Comparator.comparingInt(Person::getAge))  // 按年龄倒序
                .map(Person::getName)                             // 得到姓名
                .limit(2)                                         // 取前两个数据
                .collect(Collectors.toList());                    // 得到List<String> names
        System.out.println(top2Adult);

        //list 转 map
        Map<String, Person> personMap =
                // 以name作为key，person->person表示保留整个person作为value，(pre, next) -> pre)表示key冲突时保留旧值
                list.stream().collect(Collectors.toMap(Person::getName, person -> person, (pre, next) -> pre));
        System.out.println(personMap);

        // 如果你只需要person的部分数据作为value，比如address
        Map<String, String> personMap1 =
                list.stream().collect(Collectors.toMap(Person::getName, Person::getAddress, (pre, next) -> pre));
        System.out.println(personMap);


        //list 转 set
        // String、Integer这些类本身重写了hashCode()和equals()，可以直接toSet()
        Set<String> names = list.stream().map(Person::getName).collect(Collectors.toSet());
        System.out.println(names);

        //如果你要对自定义的对象去重，比如Person。那么你必须重写hashcode 和 equals
        Set<Person> persons = list.stream().collect(Collectors.toSet());
        System.out.println(personList);

        //一般来说，用到Collectors.toSet()之前，也是filter()等一顿操作，最后希望去重。像上面那样单纯地想得到Set，可以简单点
        Set<Person> anotherPersons = new HashSet<>(list);
        System.out.println(anotherPersons);

        //去重
        List<Person> persons2 = list.stream().distinct().collect(Collectors.toList());
        System.out.println(persons);

        //通过map去重
        // 先通过Map去重，只保留key不同的对象。
        Collection<Person> values = list.stream().collect(Collectors.toMap(Person::getName, p -> p, (pre, next) -> pre)).values();
        // 然后收集value即可
        ArrayList<Person> peoples = new ArrayList<>(values);
        System.out.println(peoples);

        

    }

    private static boolean isRichAdultInHangZhou(Person person){
        return person.getAge() >= 18
                && person.getSalary() > 888.8
                && "杭州".equals(person.getAddress());
    }



    @Getter
    @Setter
    @EqualsAndHashCode
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
