package 设计模式.pdai.单例模式.静态内部类实现;

public class Singleton {

    private Singleton () {
    }

    // 静态类，当Singleton类加载时，静态内部类 没有被加载进内存。
    private static class SingletonHolder {
        // 静态类里的静态成员变量
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getUniqueInstance () {
        return SingletonHolder.INSTANCE;
    }
}
