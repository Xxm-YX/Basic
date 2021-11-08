package 设计模式.pdai.适配器模式.类适配器模式;

//被适配对象：模拟220V的插座
public class Voltage220V {
    private int src = 220;
    //输出220V电压
    public int output220V() {
        System.out.println("电压="+src+"伏");
        return src;
    }
}
