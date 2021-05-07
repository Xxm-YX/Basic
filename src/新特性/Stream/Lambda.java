package 新特性.Stream;

import org.junit.Test;

import 序列化.User;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/2 8:58
 */
public class Lambda {

    @Test
    public void Test(){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }


        list.forEach(n -> System.out.println(n));
        list.forEach(System.out::println);

        list.forEach((String s) -> System.out.println("*" + s + "*"));

        List<Integer> primes = Arrays.asList(new Integer[]{2,3,5,7});

        int factor = 2;
//        primes.forEach(element -> {factor++; });

        System.out.println("========================");
        primes.forEach(element -> {
            System.out.println(factor*element);
        });


    }

    /**
     * @description: 惰性求值方法
     * @author zyx
     * @date 2021/5/3 16:46
     * @version 1.0
     */
    @Test
    public void Test2(){
        List<User> lists = new ArrayList<>();
        User user = new User();
        user.setName("a");
        user.setAge(1);
        User user2 = new User();
        user2.setName("a");
        user2.setAge(2);
        lists.add(user);
        lists.add(user2);
        user.setName("a");
        user.setAge(1);
        User user3 = new User();
        user3.setName("a");
        user3.setAge(3);
        lists.add(user3);
        user.setName("a");
        user.setAge(4);
        User user4 = new User();
        user4.setName("a");
        user4.setAge(2);
        lists.add(user4);
        //描述了stream，并没有创建新集合
        lists.stream().filter(f -> f.getName().equals("a"));

        List<User> a = lists.stream().filter(f -> f.getName().equals("a")).collect(Collectors.toList());

        System.out.println(a);


        List<User> collect = lists.stream().parallel().collect(Collectors.toList());
        System.out.println(collect);

    }

/**
 * @description: 常用例子
 * @author zyx
 * @date 2021/5/3 17:36
 * @version 1.0
 */
    @Test
    public void Test3(){
        //匿名类简写
        new Thread( () -> System.out.println("Rock!") ).start();
        //用法


        //forEach
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));

        //方法引用
        features.forEach(System.out::println);

        // Supplier<User> s = () -> new User();
        //Supplier 供给型接口
        Supplier<User> s = User::new;


        Set set = new HashSet();
        // set.forEach(t -> System.out.println(t));
        //对象::实例方法 Lambda表达式的(形参列表)与实例方法的(实参列表)类型，个数是对应
        set.forEach(System.out::println);

        //类名::静态方法
        // Stream<Double> stream = Stream.generate(() -> Math.random());
        Stream<Double> stream = Stream.generate(Math::random);


        //类名::实例方法
        //  TreeSet<String> set = new TreeSet<>((s1,s2) -> s1.compareTo(s2));
        /*  这里如果使用第一句话，编译器会有提示: Can be replaced with Comparator.naturalOrder，这句话告诉我们
          String已经重写了compareTo()方法，在这里写是多此一举，这里为什么这么写，是因为为了体现下面
          这句编译器的提示: Lambda can be replaced with method reference。好了，下面的这句就是改写成方法引用之后:
        */
        TreeSet<String> set2 = new TreeSet<>(String::compareTo);
    }

    /**
     * @description: Filter & Predicate 常规用法
     * @author zyx
     * @date 2021/5/3 17:46
     * @version 1.0
     */
    @Test
    public void Test4(){

        List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.startsWith("J"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.length() > 4);
    }

    public void  filter(List names, Predicate<String> condition){
        names.stream().filter( (name) -> (condition.test((String) name))).forEach((name) ->{
            System.out.println(name + "");
        });
    }

    /**
     * @description:    多个Predicate组合filter
     * @author zyx
     * @date 2021/5/5 8:59
     * @version 1.0
     */
    @Test
    public void Test5(){
        //可以用and（）、or（） 和 xor（）逻辑函数来合并Predicate
        //例如要找到所有J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;

        List name = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        name.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.println("nName, which starts with 'J' and four letter long is : " + n));
    }

    /**
     * @description: Map & Reduce
     * @author zyx
     * @date 2021/5/5 9:10
     * @version 1.0
     */
    @Test
    public void Test6(){
        List<Integer> costBeforeTax = Arrays.asList(100,200,300,400,500);

        double bill = costBeforeTax.stream().map((cost) -> cost + cost*.12).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
//        costBeforeTax.stream().map(n -> n*n).collect(Collectors.toList());
    }

    /**
     * @description: Collectors
     * @author zyx
     * @date 2021/5/5 10:23
     * @version 1.0
     */
    @Test
    public void Test7(){
        //将字符串换成大写并
    }
}
