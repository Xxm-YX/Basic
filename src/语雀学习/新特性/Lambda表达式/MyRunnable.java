package 语雀学习.新特性.Lambda表达式;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/6 19:43
 */
@FunctionalInterface
public interface MyRunnable {

    //传统的接口抽象方法，不能有方法体
    void run();

    //java8新特性，接口静态方法
    static void sing(){
        System.out.println("唱歌啦啦啦啦。。。");
    }

    //Java8新特性，接口默认方法
    default void dance(){
        System.out.println("跳舞哈哈哈");
    }
}
