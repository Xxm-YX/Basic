package 设计模式.单例模式.src.多线程的单例;

/**
 *  借助 ThreadLocal 的线程安全 的懒汉式单例
 */
public class Singleton4 {

    //ThreadLocal 线程局部变量
    private static ThreadLocal<Singleton4> threadLocal = new ThreadLocal<>();
    private static Singleton4 singleton4 = null;

    private Singleton4(){}

    public static Singleton4 getSingleton4(){
        if(threadLocal.get() == null){ //第一词检擦：该线程是否第一次访问
            createSingleton4();
        }
        return singleton4;
    }

    public static void createSingleton4(){
        synchronized (Singleton4.class){
            if(singleton4 == null){     //第二次检擦，是否被创建
                singleton4 = new Singleton4();//只执行一次
            }
        }
        threadLocal.set(singleton4);//将单例 放入当前线程的局部变量中
    }

}
