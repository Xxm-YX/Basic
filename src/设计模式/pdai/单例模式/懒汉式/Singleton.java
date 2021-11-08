package 设计模式.pdai.单例模式.懒汉式;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 *
 * 考虑以下单例模式的实现，
 * 该 Singleton 在每次序列化的时候都会创建一个新的实例，
 * 为了保证只创建一个实例，必须声明所有字段都是 transient，
 * 并且提供一个 readResolve() 方法。
 */
public class Singleton implements Serializable {

    private static volatile Singleton uniqueInstance;

    public Singleton() {
    }

    //线程不安全
    public static Singleton getUniqueInstance1() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    //线程安全
    public static synchronized Singleton getUniqueInstance2() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

    private Object readResolve() throws ObjectStreamException {
        // instead of the object we're on,
        // return the class variable INSTANCE
        return uniqueInstance;
    }


    //双重校验锁
    public static synchronized Singleton getUniqueInstance3() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
