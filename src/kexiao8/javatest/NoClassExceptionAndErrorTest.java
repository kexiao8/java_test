package kexiao8.javatest;

/**
 * Created by tommyxiao on 2/22/20 20:11
 * test cmd：
 * javac src.kexiao8.javatest.NoClassExceptionAndErrorTest.java
 * rm src.kexiao8.javatest.NoClassFoo.class
 * java src.kexiao8.javatest.NoClassExceptionAndErrorTest
 *
 * output:
 *Exception in thread "main" java.lang.NoClassDefFoundError: src.kexiao8.javatest.NoClassFoo
 *         at src.kexiao8.javatest.NoClassExceptionAndErrorTest.<clinit>(src.kexiao8.javatest.NoClassExceptionAndErrorTest.java:8)
 * Caused by: java.lang.ClassNotFoundException: src.kexiao8.javatest.NoClassFoo
 *         at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
 *         at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
 *         at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349)
 *         at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
 *         ... 1 more
 */
public class NoClassExceptionAndErrorTest {
    static NoClassFoo foo = new NoClassFoo();

    public static void main(String[] args) {
        System.out.println("I'm in NoClassDefFoundError");
    }

}
