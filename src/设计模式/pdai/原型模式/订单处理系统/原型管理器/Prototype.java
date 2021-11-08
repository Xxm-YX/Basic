package 设计模式.pdai.原型模式.订单处理系统.原型管理器;

public interface Prototype {
    public Prototype clone();
    public String getName();
    public void setName(String name);
}
