package cxl.study.orther;

public class ClassLoaderTest {

    public static void main(String[] args) {
        new Thread(new HelloHandler()).start();
    }
}
