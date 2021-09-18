package 设计模式.桥接模式.src;

/**
 * @author 78703
 * @version 1.0
 * @description: 电视抽象类   指代Implementor
 * @date 2021/5/10 22:11
 */
public abstract class TV {

    public abstract void on();

    public abstract void off();

    //换频道
    public abstract void tuneChannel();
}
