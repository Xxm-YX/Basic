package 设计模式.pdai.桥接模式.使用模式;

/**
 * 实现发送消息的统一接口
 */
public interface MessageImplementor {
    /**
     * 发送消息
     * @param message 要发送的消息内容
     * @param toUser 消息发送的目的人员
     */
    public void send(String message,String toUser);
}