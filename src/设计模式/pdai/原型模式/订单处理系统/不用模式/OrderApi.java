package 设计模式.pdai.原型模式.订单处理系统.不用模式;

/**
 * 订单的接口
 */
public interface OrderApi {
    /**
     * 获取订单产品数量
     * @return 订单中产品数量
     */
    public int getOrderProductNum();
    /**
     * 设置订单产品数量
     * @param num 订单产品数量
     */
    public void setOrderProductNum(int num);
}
