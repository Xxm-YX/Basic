package 设计模式.pdai.装饰者模式.使用模式;

import 设计模式.pdai.装饰者模式.不用模式.TempDB;

import java.util.Date;

/**
 * 装饰器对象，计算当月业务奖金
 */
public class MonthPrizeDecorator extends Decorator{
    public MonthPrizeDecorator(Component c){
        super(c);
    }
    public double calcPrize(String user, Date begin, Date end) {
        //1：先获取前面运算出来的奖金
        double money = super.calcPrize(user, begin, end);
        //2：然后计算当月业务奖金,按人员和时间去获取当月业务额，然后再乘以3%
        double prize = TempDB.mapMonthSaleMoney.get(user) * 0.03;
        System.out.println(user+"当月业务奖金"+prize);
        return money + prize;
    }
}
