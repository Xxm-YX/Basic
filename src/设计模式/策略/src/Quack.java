package 设计模式.策略.src;

/**
 * @author 78703
 * @version 1.0
 * @description: 叫声
 * @date 2021/5/14 22:26
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("quack!");
    }
}
