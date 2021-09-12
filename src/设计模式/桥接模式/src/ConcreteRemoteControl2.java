package 设计模式.桥接模式.src;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/10 22:17
 */
public class ConcreteRemoteControl2 extends RemoteControl{
    public ConcreteRemoteControl2(TV tv) {
        super(tv);
    }

    @Override
    public void on() {
        System.out.println("ConcreteRemoteControl2.on()");
        tv.on();
    }

    @Override
    public void off() {
        System.out.println("ConcreteRemoteControl2.off()");
        tv.off();
    }

    @Override
    public void tuneChannel() {
        System.out.println("ConcreteRemoteControl2.tuneChannel()");
        tv.tuneChannel();
    }
}
