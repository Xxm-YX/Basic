package 设计模式.pdai.桥接模式.不用模式;

/**
 * 以Email的方式发送普通消息
 */
public class CommonMessageEmail implements Message {
    public void send(String message, String toUser) {
        System.out.println("使用Email的方式，发送消息'"+message+"'给"+toUser);
    }
}