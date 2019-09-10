package cxl.study.orther;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class PingWithCallable implements Callable<PingWithCallable.PingResult> {

    private String ip;
    private CountDownLatch countDownLatch;

    public PingWithCallable(String ip, CountDownLatch countDownLatch) {
        this.ip = ip;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public PingResult call() throws Exception {
        PingResult result = ping();
        countDownLatch.countDown();
        return result;
    }

    private PingResult ping() {
        BufferedReader bufferedReader = null;
        PingResult result = new PingResult();
        result.setResultCode(-1);
        result.setIp(this.ip);
        try {
            Process process = new ProcessBuilder().command("ping", "-c", "1", this.ip, "-W", "1000").start();
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            result.setResultCode(process.waitFor());
//            System.out.println("result:" + result);
//            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
            result.setResultCode(-1);
        } catch (InterruptedException e) {
            e.printStackTrace();
            result.setResultCode(-1);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                result.setResultCode(-1);
            }
        }
        return result;

    }

    public class PingResult{
        private String ip;
        private int resultCode;


        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public int getResultCode() {
            return resultCode;
        }

        public void setResultCode(int resultCode) {
            this.resultCode = resultCode;
        }

        @Override
        public String toString() {
            return "PingResult{" +
                    "ip='" + ip + '\'' +
                    ", resultCode=" + resultCode +
                    '}';
        }
    }
}


