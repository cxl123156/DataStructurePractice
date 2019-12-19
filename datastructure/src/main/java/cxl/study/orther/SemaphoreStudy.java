package cxl.study.orther;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoreStudy {

    private static final Semaphore s = new Semaphore(1);
    private static Lock lock = new ReentrantLock();

    private static int data = 0;

    private static CountDownLatch countDownLatch = new CountDownLatch(1000);


    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 8, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10000));

    public static void main(String[] args) {
        while (data< 10) {
            count();
        }
        System.out.println(data);

        try {
            threadPoolExecutor.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void count() {
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                    if(data<10){
                        data++;
                    }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
