package 设计模式.pdai.单例模式.饿汉式;

public class Singleton {

    private static Singleton uniqueInstance = new Singleton();

    public Singleton() {
    }

    //线程安全
    public static Singleton getUniqueInstance() {
        return uniqueInstance;
    }
}
