package 设计模式.代理模式.src.动态代理.Demo1;



import 设计模式.代理模式.src.静态代理.BuyHouse;
import 设计模式.代理模式.src.静态代理.BuyHouseImpl;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();

        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(
                BuyHouse.class.getClassLoader(),
//ClassLoader loader:指定当前目标对象使用的类加载器,获取加载器的方法是固定的
                new Class[]{BuyHouse.class},
//Class<?>[] interfaces:指定目标对象实现的接口的类型,使用泛型方式确认类型
                new DynamicProxyHandler(buyHouse));
//InvocationHandler:指定动态处理器，执行目标对象的方法时,会触发事件处理器的invoke方法

        proxyBuyHouse.buyHouse();
    }
}
