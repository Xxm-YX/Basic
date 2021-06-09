package 语雀学习.基础进阶.枚举与应用;

public enum WeekDayEnum {
    MONDAY(1,"星期一"),
    TUESDAY(2,"星期二"),
    WEDNESDAY(3,"星期三"),
    THURSDAYDay(4,"星期四"),
    FRIDAY (5,"星期五"),
    SATURDAYDay(6,"星期六"),
    SUNDAY (7,"星期天")
    ;

    private final Integer code;
    private final String desc;

    WeekDayEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
