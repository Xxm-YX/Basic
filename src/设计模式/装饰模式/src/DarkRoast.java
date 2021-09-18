package 设计模式.装饰模式.src;

/**
 * @author 78703
 * @version 1.0
 * @description: 焦糖咖啡
 * @date 2021/5/8 15:05
 */
public class DarkRoast implements Beverage{

    @Override
    public double cost() {
        return 1;
    }
}
