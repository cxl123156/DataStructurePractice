package cxl.study.datastructure.linkedlist;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchDemo implements Runnable{

    AtomicInteger size;
    CountDownLatch countDownLatch;

    public CountDownLatchDemo(AtomicInteger size, CountDownLatch countDownLatch) {
        this.size = size;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(size.getAndDecrement());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        CountDownLatch countDownLatch = new CountDownLatch(40);
        CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo(new AtomicInteger(40),countDownLatch);
        try {
            for(int i=0;i<40;i++){
                executorService.execute(countDownLatchDemo);
            }
            countDownLatch.await();
            System.out.println("finish");
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
