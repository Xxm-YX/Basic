package 设计模式.pdai.适配器模式.类适配器模式;

public class Phone {
    //定义手机的充电功能，聚合一个充电器接口
    public void charging(IVoltage5V iVoltage5V) {
        int src = iVoltage5V.output5V();
        System.out.println("输出"+src+"V");
    }
}

