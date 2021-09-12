package 语雀学习.基础进阶.设计山寨枚举;

import 语雀学习.基础进阶.设计山寨枚举.常量类.WeekDay;

public class EmployeeDemo {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setRestDay(WeekDay.getDesc(1));
        System.out.println(employee);
    }


}
