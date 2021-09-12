package 设计模式.代理模式.src.动态代理.Demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 编写动态处理器
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public DynamicProxyHandler(final Object object){
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买房前做准备");
        Object result = method.invoke(object, args);
        System.out.println("买房后装修");

        return result;
    }
}
