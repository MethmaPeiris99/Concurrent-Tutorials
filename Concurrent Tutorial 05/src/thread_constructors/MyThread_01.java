package thread_constructors;

public class MyThread_01 extends Thread{

    public MyThread_01(){
        super();
    }

    public MyThread_01(String name){
        super(name);
    }

    public MyThread_01(ThreadGroup threadGroup, String name){
        super(threadGroup,name);
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            ThreadGroup threadGroup_two = new ThreadGroup("Thread Group 02");
            System.out.println("Thread group of Thread Group two: " + threadGroup_two.getParent().getName());

            System.out.println(Thread.currentThread().getName() + " : " +
                    Thread.currentThread().getThreadGroup().getName() + " : "+i);
        }
    }
}
