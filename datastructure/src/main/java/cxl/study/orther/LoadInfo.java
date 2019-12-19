package cxl.study.orther;

public class LoadInfo {

    /** 自定义的类加载器 */
    private CustomClassLoader customClassLoader;

    /** 记录要加载的类的时间戳-->加载的时间 */
    private long loadTime;

    private ClassLoaderTestInteface classLoaderTestInteface;

    public LoadInfo(CustomClassLoader customClassLoader, long loadTime) {
        this.customClassLoader = customClassLoader;
        this.loadTime = loadTime;
    }

    public CustomClassLoader getCustomClassLoader() {
        return customClassLoader;
    }

    public void setCustomClassLoader(CustomClassLoader customClassLoader) {
        this.customClassLoader = customClassLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public ClassLoaderTestInteface getClassLoaderTestInteface() {
        return classLoaderTestInteface;
    }

    public void setClassLoaderTestInteface(ClassLoaderTestInteface classLoaderTestInteface) {
        this.classLoaderTestInteface = classLoaderTestInteface;
    }
}
