package 并发.CASUnsafe原子类详解;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 原子更新带有版本号的引用类型更新器
 * 解决ABA问题
 */
public class AtomicStampedReferenceDemo {

    //1，创建更新器
    private static AtomicStampedReference<Integer> atomicStampedRef =
            new AtomicStampedReference<>(1,0);

    public static void main(String[] args) {
        Thread main = new Thread(() -> {
            //获取维护的版本对象引用
            System.out.println("线程操作" + Thread.currentThread() +",初始值 a = " + atomicStampedRef.getReference());
            //获取当前标识号，版本号
            int stamp = atomicStampedRef.getStamp();
            try{
                Thread.sleep(1000);//等待1秒，以便让干扰线程执行
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //此时expectedReference未发生改变，但是stamp已经被修改了，所以CAS失败
            boolean isCASSuccess = atomicStampedRef.compareAndSet(1,2,stamp,stamp +1 );
            System.out.println("操作线程"+Thread.currentThread() + ",CAS操作结果:"+isCASSuccess);
        },"主操作线程");

        Thread other = new Thread(() -> {
            Thread.yield();//确保thread—main 优先执行
            atomicStampedRef.compareAndSet(1,2,atomicStampedRef.getStamp(),atomicStampedRef.getStamp()+1);
            System.out.println("操作线程" + Thread.currentThread() +",【increment】 ,值 = "+ atomicStampedRef.getReference());
            atomicStampedRef.compareAndSet(2,1,atomicStampedRef.getStamp(),atomicStampedRef.getStamp() + 1);
            System.out.println("操作线程" + Thread.currentThread() +",【decrement】 ,值 = "+ atomicStampedRef.getReference());
        },"干扰线程");

        main.start();
        other.start();
    }
}
