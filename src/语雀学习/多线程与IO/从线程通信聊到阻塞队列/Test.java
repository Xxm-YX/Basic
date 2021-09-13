package 语雀学习.多线程与IO.从线程通信聊到阻塞队列;

public class Test {
    public static void main(String[] args) {
        //队列
        WaitNotifyQueue<String> queue= new WaitNotifyQueue<>();

        //生产者
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try{
                        queue.put("消息" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 100; i++) {
//                    try{
//                        queue.put("消息" + i);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();

        //消费者
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try{
                        queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}
