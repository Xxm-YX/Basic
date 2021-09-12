package 设计模式.策略.src;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/14 22:28
 */
public class Client {

    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setQuackBehavior(new Squeak());
        duck.performQuack();

        duck.setQuackBehavior(new Quack());
        duck.performQuack();
    }
}
