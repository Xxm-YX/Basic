package 设计模式.pdai.原型模式.订单处理系统.外观模式;

public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.watchMovie();
    }
}