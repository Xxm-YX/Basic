package 设计模式.观察者模式.src;

public interface Subject {

    //注册
    void resisterObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObserver();
}
