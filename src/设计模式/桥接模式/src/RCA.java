package 设计模式.桥接模式.src;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/10 22:12
 */

public class RCA extends TV {
    @Override
    public void on() {
        System.out.println("RCA.on()");
    }

    @Override
    public void off() {
        System.out.println("RCA.off()");
    }

    @Override
    public void tuneChannel() {
        System.out.println("RCA.tuneChannel()");
    }
}