package cxl.study.orther;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class CustomClassLoader extends ClassLoader {

    private String classpath;

    public CustomClassLoader(String classpath) {
        super(ClassLoader.getSystemClassLoader());
        this.classpath = classpath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }

    /**
     * 加载 class 文件中的内容
     *
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        try {
            // 传进来是带包名的
            name = name.replace(".", File.separator);
            FileInputStream inputStream = new FileInputStream(new File(classpath + name + ".class"));
            // 定义字节数组输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = inputStream.read()) != -1) {
                baos.write(b);
            }
            inputStream.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
