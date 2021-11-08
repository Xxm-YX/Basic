package 设计模式.pdai.原型模式.订单处理系统.使用原型模式;

/**
 * 企业订单对象
 */
public class EnterpriseOrder implements OrderApi, Cloneable{
    private String enterpriseName;
    private String productId;
    private int orderProductNum = 0;
    public int getOrderProductNum() {
        return this.orderProductNum;
    }
    public void setOrderProductNum(int num) {
        this.orderProductNum = num;
    }
    public String getEnterpriseName() {
        return enterpriseName;
    }
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String toString(){
        return "本企业订单的订购企业是="+this.enterpriseName+"，订购产品是="+this.productId+"，订购数量为="+this.orderProductNum;
    }
    /*public OrderApi cloneOrder() {
        //创建一个新的订单，然后把本实例的数据复制过去
        EnterpriseOrder order = new EnterpriseOrder();
        order.setEnterpriseName(this.enterpriseName);
        order.setProductId(this.productId);
        order.setOrderProductNum(this.orderProductNum);
        return order;
    }*/

    public Object clone() {
        //克隆方法的真正实现，直接调用父类的克隆方法就可以了
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
