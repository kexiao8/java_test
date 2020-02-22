public class TwoThreadGetNameTest extends Thread {

    public void run() {
       for (int i = 0; i < 10; i++) {
          printMsg();
       }
    }

    public void printMsg() {
       Thread t = Thread.currentThread();
       String name = t.getName();
       System.out.println("name=" + name);
    }

    public static void main(String[] args) {
       TwoThreadGetNameTest inst = new TwoThreadGetNameTest();
       inst.start();//thread 0
       for (int i = 0; i < 10; i++) {
          inst.printMsg();//main
       }
    }
 }