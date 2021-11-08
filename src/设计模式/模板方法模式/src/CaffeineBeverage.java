package 设计模式.模板方法模式.src;

public abstract class CaffeineBeverage {

    final void prepareRecipe () {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater() {
        System.out.println("boilWater");
    }

    void pourInCup() {
        System.out.println("pourInCup");
    }


}
