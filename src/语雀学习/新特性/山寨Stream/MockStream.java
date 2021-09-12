package 语雀学习.新特性.山寨Stream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/14 17:37
 */
public class MockStream {

    public static void main(String[] args) throws JsonProcessingException {
        MyList<Person> personMyList = new MyList<>();
        personMyList.add(new Person("李建",46));
        personMyList.add(new Person("周深",28));
        personMyList.add(new Person("张学友",59));

        //需求，过滤出年龄大于40的歌手的名字
        //解释：首先进行过滤，接着转换成name 进行显示
        MyList<String> result = personMyList.filter(person -> person.getAge() > 40).map(Person::getName);
        prettyPrint(result.getList());

        System.out.println("\n-----------------------------\n");

        // 对比真正的Stream API
        List<Person> list = new ArrayList<>();
        list.add(new Person("李建",46));
        list.add(new Person("周深", 28));
        list.add(new Person("张学友", 59));

        List<String> collect = list
                .stream()   //真正的Stream API 需要先转成stream流
                .filter(person -> person.getAge() > 40)// 过滤出年纪大于40的歌手
                .map(Person::getName)// 拿到他们的名字
                .collect(Collectors.toList());//整理成List<String>

        prettyPrint(collect);
    }

    /**
     * @description: 按JSON格式输出
     * @author zyx
     * @date 2021/5/14 20:05
     * @version 1.0
     */
    private static void prettyPrint(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        System.out.println(s);
    }




    @Data
    @AllArgsConstructor
    static
    class Person{
        private String name;
        private Integer age;
    }

}


