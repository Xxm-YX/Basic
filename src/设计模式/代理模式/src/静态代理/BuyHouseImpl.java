package 设计模式.代理模式.src.静态代理;

/**
 * 服务类接口实现类
 */
public class BuyHouseImpl implements BuyHouse{
    @Override
    public void buyHouse() {
        System.out.println("我要买房");
    }
}
