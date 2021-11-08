package 设计模式.pdai.桥接模式.使用模式;

public class CommonMessage extends AbstractMessage{
    public CommonMessage(MessageImplementor impl) {
        super(impl);
    }
    public void sendMessage(String message, String toUser) {
        //对于普通消息，什么都不干，直接调父类的方法，把消息发送出去就可以了
        super.sendMessage(message, toUser);
    }
}
