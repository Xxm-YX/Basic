package 设计模式.单例模式.src.饿汉模式;

/**
 *
 */
public class HungryMode {

    /**
     * 所谓 饿汉式 单例，就是有一个私有的构造方法
     * + 私有的静态当前类实例  +  公有的静态获取实例方法
     * 由于类实例对象为 静态变量，加载类时 会创建实例对象
     *
     * 饿汉 故名思意，很饿，不管有多少 都要吃掉
     *
     * 这样会比较消耗内存
     *
     * 按需加载 且加载一次
     *
     * 优点：类加载时 完成实例化，避免线程同步问题
     * 缺点：类加载时完成实例化，但是 没有达到Lazy Loading效果，如果从未使用，亏
     */
    private static HungryMode sHungryMode = new HungryMode();

    private HungryMode(){
        System.out.println("creat" + getClass().getSimpleName());
    }

    public static void fun(){
        System.out.println("call fun in HungryMode");
    }

    public static HungryMode getInstance(){
        return sHungryMode;
    }

    public static void main(String[] args) {
        HungryMode.fun();
        System.out.println(HungryMode.getInstance());
    }
}
