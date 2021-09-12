package 设计模式.装饰模式.src;

/**
 * @author 78703
 * @version 1.0
 * @description: 用户
 * @date 2021/5/8 15:09
 */
public class Client {

    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
        beverage = new Milk(beverage);

        System.out.println(beverage.cost());
    }
}
