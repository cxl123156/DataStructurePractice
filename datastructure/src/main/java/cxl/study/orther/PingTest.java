package cxl.study.orther;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class PingTest implements Runnable {

    private String ip;
    private CountDownLatch countDownLatch;

    public PingTest(String ip, CountDownLatch countDownLatch) {
        this.ip = ip;
        this.countDownLatch = countDownLatch;
    }

    public static void main(String[] args) {
//        String[] ipaddts = {"192.168.2.1","192.168.124.1","192.168.124.7","192.168.124.2",
//                "192.168.2.64","192.168.2.116","192.168.2.194","192.168.2.147","192.168.2.237"};
        int maxIpCount = 3000;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(500, 1000,
                10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(maxIpCount));
        CountDownLatch countDownLatch = new CountDownLatch(maxIpCount-1);
        ConcurrentHashMap<String, Integer> resultMap = new ConcurrentHashMap<>(maxIpCount);
        List<Future<PingWithCallable.PingResult>> resultList = new ArrayList<>(maxIpCount);

        String[] ipaddts = new String[maxIpCount];
        int hostIpIndex = 0;
        while (hostIpIndex < maxIpCount - 1) {
            hostIpIndex++;
            ipaddts[hostIpIndex] = "192.168.2." + hostIpIndex;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < ipaddts.length; i++) {
            if (ipaddts[i] == null) {
                continue;
            }
            PingTest pingTest = new PingTest(ipaddts[i], countDownLatch);
//                PingWithCallable pingWithCallable = new PingWithCallable(ipaddts[i],countDownLatch);
            threadPoolExecutor.execute(pingTest);
            //                resultList.add(futureResult);
        }
        try {
            countDownLatch.await();
            System.out.println("cost time:" + (System.currentTimeMillis() - startTime));
            threadPoolExecutor.shutdown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void ping() {
        BufferedReader bufferedReader = null;
        try {
            Process process = new ProcessBuilder().command("ping", "-c", "1", this.ip, "-W", "1000").start();
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            System.out.println("result:" + process.waitFor());
//            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {
        this.ping();
        countDownLatch.countDown();
    }
}
