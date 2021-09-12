package 设计模式.单例模式.src.多线程的单例;

/**
 * 多线程的单例，这个单例 在 懒加载的基础上 来进行改造
 *
 * 多线程 会出现多个对象，需要在 获取类实例上加上““同步锁””
 *
 * 并且 给类实例对象加上 volatile修饰符，能保证对象的可见性
 *      即在工作内存的内容更新 能立即在主内存中可见，
 *      工作内存：各个线程独有的内存
 *      主内存：所有线程共享的内存
 *      还有一个作用：（禁止指令重排序优化）
 *              有的编辑器 会进行优化，执行顺序 跟 代码顺序不同
 *              这在单线程看起来可以，但是多线程不行，volatile从语义上解决了这个问题
 */
public class LazyMode {

    private static volatile LazyMode sLazyMode;

    private LazyMode(){
        System.out.println("create " + getClass().getSimpleName());
    }

    //性能问题，多个线程获取实例对象 会排队等待 获取锁
    //其实没必要，大多数 已经创建成功了，不用进入加锁的代码快
    //进行优化， 双重校验的单例模式
    public static LazyMode getInstance(){
        synchronized (LazyMode.class){  //同步代码快
            if(sLazyMode == null){
                sLazyMode = new LazyMode();
            }
        }
        return sLazyMode;
    }

    public static void main(String[] args) {
        LazyMode.getInstance();
    }
}
