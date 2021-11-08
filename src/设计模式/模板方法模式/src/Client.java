package 设计模式.模板方法模式.src;

public class Client {

    public static void main(String[] args) {
        CaffeineBeverage caffeineBeverage = new Coffee();
        caffeineBeverage.prepareRecipe();
        System.out.println("--------------");
        caffeineBeverage = new Tea();
        caffeineBeverage.prepareRecipe();
    }
}
