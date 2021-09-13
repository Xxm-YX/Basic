package 设计模式.装饰者模式;

public class EggDecorator extends BattercakeDirect{

    public EggDecorator(Battercake battercake) {
        super(battercake);
    }

    @Override
    public String getMsg(){
        return super.getMsg() + "加了一个鸡蛋";
    }

    @Override
    public int getPrice(){
        return (int) (super.getPrice() + 1);
    }

}
