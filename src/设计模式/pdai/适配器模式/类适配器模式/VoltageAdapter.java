package 设计模式.pdai.适配器模式.类适配器模式;

public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    @Override
    public int output5V() {
        // TODO Auto-generated method stub
        int src = output220V();
        //模拟src->dst的适配
        int dst =src/44;
        return dst;
    }
}

