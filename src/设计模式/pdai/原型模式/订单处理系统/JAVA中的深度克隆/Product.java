package 设计模式.pdai.原型模式.订单处理系统.JAVA中的深度克隆;

public class Product implements Cloneable{
    private String productId;
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String toString(){
        return "产品编号="+this.productId+"，产品名称="+this.name;
    }
    public Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
