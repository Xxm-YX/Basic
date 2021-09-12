package 设计模式.代理模式.src.动态代理.Demo2;

import 设计模式.代理模式.src.静态代理.BuyHouse;
import 设计模式.代理模式.src.静态代理.BuyHouseImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest2 {

    public static void main(String[] args) {
        BuyHouseImpl target = new BuyHouseImpl();
        BuyHouse buyHouseProxy = (BuyHouse) getProxy(target);
        buyHouseProxy.buyHouse();
    }

    public static Object getProxy(final Object target){

        Object proxy = Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(method.getName());
                        Object res = method.invoke(target, args);
                        System.out.println(res);
                        System.out.println(method.getName());
                        return res;
                    }
                }
        );
        return proxy;
    }
}
