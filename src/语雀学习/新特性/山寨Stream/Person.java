package 语雀学习.新特性.山寨Stream;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/14 17:39
 */
public class Person {

    private String name;
    private Integer age;
    private Double money;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Double getMoney() {
        return money;

    }

    public Person setName(String name) {
        this.name = name;
        // set方法要返回this，方便继续调用下一个set
        return this;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Person setMoney(Double money) {
        this.money = money;
        return this;
    }
}
