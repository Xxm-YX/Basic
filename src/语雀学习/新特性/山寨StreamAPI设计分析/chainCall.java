package 语雀学习.新特性.山寨StreamAPI设计分析;

public class chainCall {
    public static void main(String[] args) {
        Person1 bravo1988 = new Person1().setName("bravo1988").setAge(18).setMoney(1000.0);
    }
}

class Person1{
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

    public Person1 setName(String name) {
        this.name = name;
        // set方法要返回this，方便继续调用下一个set
        return this;
    }

    public Person1 setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Person1 setMoney(Double money) {
        this.money = money;
        return this;
    }


}
