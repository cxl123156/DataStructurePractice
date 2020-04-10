package cxl.study.jvm.classloader;

public class TestParent {

    public static void main(String[] args) {
        System.out.println(TestStatic.i);
    }

}

class TestStatic{

    public static final String str = "hello world";
    public static final int i = 100000;

    static {
        System.out.println("this is static code");
    }

}
