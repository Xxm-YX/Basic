package 设计模式.装饰者模式;

/**
 * 基类
 **/
public class BaseBattercake extends Battercake{
    @Override
    protected String getMsg() {
        return "煎饼";
    }

    @Override
    protected int getPrice() {
        return 6;
    }
}
