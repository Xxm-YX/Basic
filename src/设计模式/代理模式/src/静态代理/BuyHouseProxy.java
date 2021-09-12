package 设计模式.代理模式.src.静态代理;

/**
 * 代理类，，，要实现 被代理类 一样的接口
 */
public class BuyHouseProxy implements BuyHouse{

    private BuyHouse buyHouse;

    public BuyHouseProxy(final BuyHouse buyHouse){
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        System.out.println("买房前准备");
        buyHouse.buyHouse();
        System.out.println("买房后装修");
    }
}
