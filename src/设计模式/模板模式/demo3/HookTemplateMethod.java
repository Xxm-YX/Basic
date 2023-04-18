package 设计模式.模板模式.demo3;

public class HookTemplateMethod {

    public static void main(String[] args) {
        HookAbstractClass tm = new HookConcreteClass();
        tm.TemplateMethod();
    }
}
