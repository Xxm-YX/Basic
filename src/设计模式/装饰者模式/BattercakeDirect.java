package 设计模式.装饰者模式;

/**
 * 抽象装饰类
 **/
public class BattercakeDirect extends Battercake{

    private Battercake battercake;

    public BattercakeDirect(Battercake battercake) {
        this.battercake = battercake;
    }

    @Override
    protected String getMsg() {
        return this.battercake.getMsg();
    }

    @Override
    protected int getPrice() {
        return this.battercake.getPrice();
    }
}
