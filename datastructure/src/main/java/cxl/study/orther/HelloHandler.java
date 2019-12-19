package cxl.study.orther;

public class HelloHandler implements Runnable {



    @Override
    public void run() {
        while (true){
            ClassLoaderTestInteface classLoaderTestInteface = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            classLoaderTestInteface.sayHi();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
