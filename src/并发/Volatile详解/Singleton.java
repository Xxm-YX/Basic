package 并发.Volatile详解;

/**
 * 防重排序
 * 使用单例模式来分析
 */
public class Singleton {

    public static volatile Singleton singleton;

    /**
     * 构造函数私有，禁止外部实例化
     */
    private Singleton() {};

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (singleton.getClass()) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
