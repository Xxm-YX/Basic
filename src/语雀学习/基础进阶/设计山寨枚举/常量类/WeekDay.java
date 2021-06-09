package 语雀学习.基础进阶.设计山寨枚举.常量类;

import lombok.Data;
import lombok.Getter;

/**
 * 常量类
 */
@Data
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
    public static final WeekDay MONDAY;
    public static final WeekDay TUESDAY;
    public static final WeekDay WEDNESDAY;
    public static final WeekDay THURSDAY;
    public static final WeekDay FRIDAY;
    public static final WeekDay SATURDAY;
    public static final WeekDay SUNDAY;

    private static final WeekDay[] VALUES;

    static {
        MONDAY = new WeekDay(1,"星期一");
        TUESDAY = new WeekDay(2,"星期二");
        WEDNESDAY = new WeekDay(3,"星期三");
        THURSDAY = new WeekDay(4,"星期四");
        FRIDAY = new WeekDay(5,"星期五");
        SATURDAY = new WeekDay(6,"星期六");
        SUNDAY = new WeekDay(7,"星期天");
        VALUES = (new WeekDay[]{
                MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        });
    }

    //返回所有对象
    public static WeekDay[] values(){
        return VALUES;
    }

    //遍历对象，根据code返回code对应的desc

    public static WeekDay getDesc(Integer code) {
        WeekDay[] weekDays = WeekDay.values();
        for (WeekDay weekDay : weekDays) {
            if(weekDay.getCode().equals(code)){
                return weekDay;
            }
        }
        throw new IllegalArgumentException("Invalid Enum code:" + code);
    }


    /**
     * 校验前端传入的code是否合法
     * @param code
     * @return
     */
//    public static WeekDay of(Integer code){
//        for (WeekDay weekDay : VALUES) {
//            if (weekDay.code.equals(code)) {
//                return weekDay;
//            }
//        }
//        // 如果根据code找不到对应的WeekDay，说明code范围不对，是非法的
//        throw new IllegalArgumentException("Invalid Enum code:" + code);
//    }

}
