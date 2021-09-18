package 语雀学习.新特性.山寨Stream;

/**
 * @description: 定义一个Function接口，名字无所谓
 * @author zyx
 * @date 2021/5/14 17:57
 * @version 1.0
 */
@FunctionalInterface
public interface Function<E,R>{
    /**
     * 定义一个apply()方法，接收一个E返回一个R。也就是把E映射成R
     *
     * @param e
     * @return
     */
    R apply(E e);
}