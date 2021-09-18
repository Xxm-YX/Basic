package 设计模式.代理模式.src.CGLIB代理类.Demo2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

//代理类

public class ProgrammerProxy implements MethodInterceptor {

    //内部持有委托类的引用


    private Object target;

    //创建代理类对象
    public Programmer createProxy(Programmer object){
        target = object;
        //创建Enhancer对象
        Enhancer enhancer = new Enhancer();
        //设置要代理的目标类，加强方法
        enhancer.setSuperclass(this.target.getClass());

        //设置单一回调对象，在回调中 拦截对目标方法的调用
        enhancer.setCallback(this);

        //设置类加载器
        enhancer.setClassLoader(object.getClass().getClassLoader());

        //创建代理对象
        return (Programmer) enhancer.create();
    }


    /**
     *  回调方法，在代理实例上拦截并处理目标方法的调用，返回结果
     * @param proxy  代理类
     * @param method 被代理的方法
     * @param params 该方法的参数组
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        //调用之前处理
        doBefore();

        //调用原方法
        method.invoke(target,params);

        //调用之后处理
        doAfter();

        return null;
    }

    public void doAfter(){
        System.out.println("do after.");
    }

    public void doBefore(){
        System.out.println("do before");
    }
}
