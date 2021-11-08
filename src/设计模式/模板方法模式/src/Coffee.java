package 设计模式.模板方法模式.src;

public class Coffee extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("Coffee.brew");
    }

    @Override
    void addCondiments() {
        System.out.println("Coffee.addCondiments");
    }
}
