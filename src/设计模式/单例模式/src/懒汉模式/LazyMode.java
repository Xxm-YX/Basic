package 设计模式.单例模式.src.懒汉模式;

/**
 * 当 这个对象构造方法很复杂，这样的单例写法会造成 类加载很慢，会浪费很多性能
 *
 * 需要懒加载，所谓的懒汉式加载
 *
 *
 * 真正需要的时候 才创建实例   不适用多线程
 */
public class LazyMode {

    private static LazyMode sLazyMode;

    private LazyMode(){
        System.out.println("create " + getClass().getSimpleName());
    }

    private static LazyMode getInstance(){
        if(sLazyMode == null){
            sLazyMode = new LazyMode();
        }
        return sLazyMode;
    }


}
