package cxl.study.orther;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ManagerFactory {

    /** 记录热加载类的加载信息 */
    private static final Map<String, LoadInfo> loadTimeMap = new HashMap<>();

    /** 要加载的类的 classpath */
    public static final String CLASS_PATH = "/Users/chenxianglin/IdeaProjects/DataStructurePractice/datastructure/out/production/classes";

    /** 实现热加载的类的全名称(包名+类名 ) */
    public static final String MY_MANAGER = "cxl.study.orther.ClassLoaderTestHello";


    public static ClassLoaderTestInteface getManager(String className) {
        File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        // 获取最后一次修改时间
        long lastModified = loadFile.lastModified();
        System.out.println("当前的类时间：" + lastModified);
        // loadTimeMap 不包含 ClassName 为 key 的信息，证明这个类没有被加载，要加载到 JVM
        if (loadTimeMap.get(className) == null) {
            load(className, lastModified);
        } // 加载类的时间戳变化了，我们同样要重新加载这个类到 JVM。
        else if (loadTimeMap.get(className).getLoadTime() != lastModified) {
            load(className, lastModified);
        }
        return loadTimeMap.get(className).getClassLoaderTestInteface();
    }

    /**
     * 加载 class ，缓存到 loadTimeMap
     *
     * @param className
     * @param lastModified
     */
    private static void load(String className, long lastModified) {
        CustomClassLoader customClassLoader = new CustomClassLoader(className);
        Class loadClass = null;
        // 加载
        try {
            loadClass = customClassLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        ClassLoaderTestInteface classLoaderTestInteface = newInstance(loadClass);
        LoadInfo loadInfo = new LoadInfo(customClassLoader, lastModified);
        loadInfo.setClassLoaderTestInteface(classLoaderTestInteface);
        loadTimeMap.put(className, loadInfo);
    }

    /**
     * 以反射的方式创建 BaseManager 的子类对象
     *
     * @param loadClass
     * @return
     */
    private static ClassLoaderTestInteface newInstance(Class loadClass) {
        try {
            return (ClassLoaderTestInteface)loadClass.getConstructor(new Class[] {}).newInstance(new Object[] {});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
