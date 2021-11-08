package 设计模式.pdai.原型模式.订单处理系统.原型管理器;

public class ConcretePrototype2 implements Prototype {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Prototype clone() {
        ConcretePrototype2 prototype = new ConcretePrototype2();
        prototype.setName(this.name);
        return prototype;
    }
    public String toString(){
        return "Now in Prototype2，name="+name;
    }
}