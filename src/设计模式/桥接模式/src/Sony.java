package 设计模式.桥接模式.src;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/10 22:12
 */
public class Sony extends TV{
    @Override
    public void on() {
        System.out.println("Sony.on()");
    }

    @Override
    public void off() {
        System.out.println("Sony.off()");
    }

    @Override
    public void tuneChannel() {
        System.out.println("Sony.tuneChannel()");
    }
}
