package 设计模式.单例模式.src.静态内部类实例单例;

/**
 * 利用静态类 只会加载一次的机制
 * 使用 静态内部类 持有单例模式
 *
 * 保证 多线程的对象唯一性，还有 提升性能，不用同步锁机制
 */
public class InnerStaticMode {

    private static class SingleTonHolder{
        //静态类
        public static InnerStaticMode sInnerStaticMode =new  InnerStaticMode();

    }

    public static InnerStaticMode getInstance(){
        return SingleTonHolder.sInnerStaticMode;
    }
}
