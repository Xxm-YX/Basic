package 设计模式.pdai.适配器模式.类适配器模式;

public class client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        //使用VoltageAdapter充电器对手机进行充电
        phone.charging(new VoltageAdapter());
    }
}
