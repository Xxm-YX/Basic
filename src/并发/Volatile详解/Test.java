package 并发.Volatile详解;

public class Test {
    private volatile int a;
    public void update(){
        a = 1;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.update();
    }
}
