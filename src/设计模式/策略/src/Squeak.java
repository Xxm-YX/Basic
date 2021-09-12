package 设计模式.策略.src;

/**
 * @author 78703
 * @version 1.0
 * @description: 另一种叫声
 * @date 2021/5/14 22:27
 */
public class Squeak implements QuackBehavior{


    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}
