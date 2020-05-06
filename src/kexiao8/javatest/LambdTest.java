package kexiao8.javatest;

/**
 * Created by tommyxiao on 2/22/20 20:14
 */
public class LambdTest {
    public static void main(String[] args) {
        //old
        new Thread((new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类 实现线程");
            }
        })).start();

        //lambda
        new Thread( () -> System.out.println("java8 lambda实现线程")).start();
    }
}
