package 设计模式.桥接模式.src;

/**
 * @author 78703
 * @version 1.0
 * @description:
 * @date 2021/5/10 22:18
 */
public class Client {

    public static void main(String[] args) {
        RemoteControl remoteControl = new ConcreteRemoteControl1(new RCA());
        remoteControl.on();
        remoteControl.off();
        remoteControl.tuneChannel();
    }
}
