package 设计模式.单例模式.src.多线程的单例;

/**
 * 多线程的单例模式   采用双重校验机制
 *
 * 效率 和 安全 双重保证
 *      JDK1.5后 禁止指令重排优化
 */
public class DoubleCheckMode {

    private volatile static DoubleCheckMode sDoubleCheckMode;

    public DoubleCheckMode(){
        System.out.println("create " + getClass().getSimpleName());
    }

    public static DoubleCheckMode getInstance(){
        if(sDoubleCheckMode == null){
            synchronized (DoubleCheckMode.class){
                if(sDoubleCheckMode == null){
                    sDoubleCheckMode = new DoubleCheckMode();
                }
            }

        }
        return sDoubleCheckMode;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(){

                @Override
                public void run() {
                    super.run();
                    System.out.println("thread" + getId());
                    DoubleCheckMode.getInstance();
                }
            }.start();
        }
    }
}
