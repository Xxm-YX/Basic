package 语雀学习.基础进阶.设计山寨枚举;

import lombok.Data;
import 语雀学习.基础进阶.设计山寨枚举.常量类.WeekDay;

@Data
public class Employee {

    /**
     * 指定员工在哪一天休息
     */
    private Integer restDay;
    private String restDayDesc;
    public void setRestDay(WeekDay weekDay) {
//        if(restDay > 7 || restDay < 1){
//            throw new RuntimeException("restDay只能填写1~7之间的值");
//        }
        this.restDay = weekDay.getCode();
        this.restDayDesc = weekDay.getDesc();
    }



}
