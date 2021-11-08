package 设计模式.pdai.原型模式.订单处理系统.JAVA中的深度克隆;

import 设计模式.pdai.原型模式.订单处理系统.使用原型模式.OrderApi;

public class PersonalOrder implements Cloneable , OrderApi {
    private String customerName;
    private Product product = null;
    private int orderProductNum = 0;
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
    public Object clone(){
        PersonalOrder obj=null;
        try {
            obj =(PersonalOrder)super.clone();
            //下面这一句话不可少
            obj.setProduct((Product)this.product.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}