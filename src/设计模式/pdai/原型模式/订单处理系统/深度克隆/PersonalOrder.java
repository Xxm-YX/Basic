package 设计模式.pdai.原型模式.订单处理系统.深度克隆;

import 设计模式.pdai.原型模式.订单处理系统.不用模式.OrderApi;

public class PersonalOrder implements OrderApi {
    private String customerName;
    private int orderProductNum = 0;
    /**
     * 产品对象
     */
    private Product product = null;

    public int getOrderProductNum() {
        return this.orderProductNum;
    }
    public void setOrderProductNum(int num) {
        this.orderProductNum = num;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public String toString(){
        //简单点输出
        return "订购产品是="+this.product.getName()+"，订购数量为="+this.orderProductNum;
    }
    public OrderApi cloneOrder() {
        //创建一个新的订单，然后把本实例的数据复制过去
        PersonalOrder order = new PersonalOrder();
        order.setCustomerName(this.customerName);
        order.setOrderProductNum(this.orderProductNum);
        //对于对象类型的数据，深度克隆的时候需要继续调用这个对象的克隆方法
        order.setProduct((Product)this.product.cloneProduct());
        return order;
    }
}
