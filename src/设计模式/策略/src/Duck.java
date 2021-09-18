package 设计模式.策略.src;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/14 22:27
 */
public class Duck {

    private QuackBehavior quackBehavior;

    public void performQuack(){
        if(quackBehavior != null){
            quackBehavior.quack();
        }
    }

    public void setQuackBehavior(QuackBehavior quackBehavior){
        this.quackBehavior = quackBehavior;
    }
}
