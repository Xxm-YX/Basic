package 语雀学习.基础进阶.设计山寨枚举.Enum;

import lombok.Getter;

/**
 * 常量类
 */
@Getter
public class WeekDay {

    //私有构造方，单例模式，外界不能new
//    private WeekDay(){}

    //因为final是只能赋值一次，而创建对像时会进行显式赋值，必须要禁用无参构造
    //强制走有参构造，保证final字段初始化
    private final Integer code;
    private final String desc;

    private WeekDay(Integer code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public static final WeekDay MONDAY = new WeekDay(1,"星期一");
    public static final WeekDay TUESDAY = new WeekDay(2,"星期二");
    public static final WeekDay WEDNESDAY = new WeekDay(3,"星期三");
    public static final WeekDay THURSDAY = new WeekDay(4,"星期四");
    public static final WeekDay FRIDAY = new WeekDay(5,"星期五");
    public static final WeekDay SATURDAY = new WeekDay(6,"星期六");
    public static final WeekDay SUNDAY = new WeekDay(7,"星期天");


}
