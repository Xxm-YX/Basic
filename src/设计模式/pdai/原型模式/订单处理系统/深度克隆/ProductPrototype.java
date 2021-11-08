package 设计模式.pdai.原型模式.订单处理系统.深度克隆;

/**
 * 声明一个克隆产品自身的接口
 */
public interface ProductPrototype {
    /**
     * 克隆产品自身的方法
     * @return 一个从自身克隆出来的产品对象
     */
    public ProductPrototype cloneProduct();
}