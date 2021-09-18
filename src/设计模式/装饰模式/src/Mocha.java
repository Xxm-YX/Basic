package 设计模式.装饰模式.src;

/**
 * @author 78703
 * @version 1.0
 * @description: 抹茶配料
 * @date 2021/5/8 15:08
 */
public class Mocha extends CondimentDecorator{


    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + beverage.cost();
    }
}
