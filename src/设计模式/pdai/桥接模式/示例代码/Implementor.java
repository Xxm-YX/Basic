package 设计模式.pdai.桥接模式.示例代码;

/**
 * 定义实现部分的接口，可以与抽象部分接口的方法不一样
 */
public interface Implementor {
    /**
     * 示例方法，实现抽象部分需要的某些具体功能
     */
    public void operationImpl();
}
