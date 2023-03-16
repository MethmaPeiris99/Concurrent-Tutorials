package thread_constructors;

public class MyThread_02 implements Runnable{

    @Override
    public void run() {
        for (int i = 65; i < 120; i++) {
            System.out.println(Thread.currentThread().getName() + " : " +
                    Thread.currentThread().getThreadGroup().getName() + " : "+((char)i));
        }
    }
}
