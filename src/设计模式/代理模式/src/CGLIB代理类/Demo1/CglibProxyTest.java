package 设计模式.代理模式.src.CGLIB代理类.Demo1;


import 设计模式.代理模式.src.静态代理.BuyHouse;
import 设计模式.代理模式.src.静态代理.BuyHouseImpl;

public class CglibProxyTest {
    public static void main(String[] args){
        BuyHouse buyHouse = new BuyHouseImpl();
        CglibProxy cglibProxy = new CglibProxy();
        BuyHouseImpl buyHouseCglibProxy = (BuyHouseImpl) cglibProxy.getInstance(buyHouse);
        buyHouseCglibProxy.buyHouse();
    }
}
