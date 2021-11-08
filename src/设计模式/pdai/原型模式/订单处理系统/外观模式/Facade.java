package 设计模式.pdai.原型模式.订单处理系统.外观模式;

public class Facade {

    private SubSystem subSystem = new SubSystem();

    public void watchMovie() {
        subSystem.turnOnTV();
        subSystem.setCD("a movie");
        subSystem.starWatching();
    }
}
