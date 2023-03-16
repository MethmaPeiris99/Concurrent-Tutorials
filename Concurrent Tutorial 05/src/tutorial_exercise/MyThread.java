package tutorial_exercise;

public class MyThread extends Thread{

    public MyThread(String name){
        super(name);
    }

    public MyThread(ThreadGroup threadGroup, String name){
        super(threadGroup, name);
    }

    @Override
    public void run() {
        System.out.println("Thread Name: "+Thread.currentThread().getName()+" | "+
                    "Thread Group Name: "+Thread.currentThread().getThreadGroup().getName());
    }
}
