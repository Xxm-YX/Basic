package 设计模式.桥接模式.src;

/**
 * @author 78703
 * @version 1.0
 * @description: 遥控器，指代Abstractiom
 * @date 2021/5/10 22:13
 */
public abstract class RemoteControl {

    protected TV tv;

    public RemoteControl(TV tv){
        this.tv = tv;
    }

    public abstract void on();

    public abstract void off();

    public abstract void tuneChannel();
}
