package 设计模式.装饰者模式;

/**
 * 加一块肉
 **/
public class PorkDecrator extends BattercakeDirect{
    public PorkDecrator(Battercake battercake) {
        super(battercake);
    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "加了一块肉";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 4;
    }
}
