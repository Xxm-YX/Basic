package 设计模式.装饰模式.src;

/**
 * @author 78703
 * @version 1.0
 * @description: 牛奶配料
 * @date 2021/5/8 15:07
 */
public class Milk extends CondimentDecorator{



    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + beverage.cost();
    }
}
