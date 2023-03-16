public class MyThread extends Thread {
    public MyThread(ThreadGroup threadGroup, String name) {
        super(threadGroup, name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread Group Name : " + Thread.currentThread().getThreadGroup().getName() +
                    " Thread Name : " + Thread.currentThread().getName() +
                    " : " + i);
        }
    }
}
