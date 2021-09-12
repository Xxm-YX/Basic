package 语雀学习.基础进阶.枚举与应用;

public enum ExceptionEnum {
    USER_NOT_FOUND(1,"用户不存在"),
    PARAM_INVALID(2,"参数错误"),
    ;


    private final Integer code;
    private final String desc;


    ExceptionEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
