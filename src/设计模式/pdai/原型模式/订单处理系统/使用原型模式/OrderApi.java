package 设计模式.pdai.原型模式.订单处理系统.使用原型模式;

/**
 * 订单的接口，声明了可以克隆自身的方法
 */
public interface OrderApi {
    int getOrderProductNum();

    void setOrderProductNum(int num);

    /**
     * 克隆方法
     *
     * @return 订单原型的实例
     */
//    public OrderApi cloneOrder();
    public Object clone();
}