package 设计模式.代理模式.src.动态代理.Demo2;



import 设计模式.代理模式.src.静态代理.BuyHouse;
import 设计模式.代理模式.src.静态代理.BuyHouseImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest{
    public static void main(String[] args) throws Throwable {
        /**
         * 参数1：ByHouse的类加载器(把ByHouse加载进内存的类加载器)
         * 参数2：代理对象需要和目标对象实现相同接口ByHouse
         */
        Class BuyHouseProxyClazz = Proxy.getProxyClass(
                BuyHouse.class.getClassLoader(),
                BuyHouse.class);



        //得到有参构造器，$Proxy0(InvocationHandler h)
        Constructor constructor = BuyHouseProxyClazz.getConstructor(InvocationHandler.class);

        //通过反射创建代理实例
        BuyHouse buyHouseProxyImpl = (BuyHouse)
                constructor.newInstance(new InvocationHandler() {



            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //手动new一个 创造一个真正的实例
                BuyHouse buyHouse = new BuyHouseImpl();
                //反射执行目标对象的方法
                Object result = method.invoke(buyHouse, args);
                return result;
            }
        });

        buyHouseProxyImpl.buyHouse();
    }
}
