package tutorial_exercise;

public class Main {
    public static void main(String[] args) {

        ThreadGroup[] threadGroups = new ThreadGroup[6];
        Thread[] threads = new Thread[7];

        threadGroups[0] = Thread.currentThread().getThreadGroup(); //Add main thread group to index 0 of threadGroups array

        ThreadGroup threadGroup_A = new ThreadGroup("Thread Group A");
        threadGroups[1] = threadGroup_A;

        ThreadGroup threadGroup_B = new ThreadGroup("Thread Group B");
        threadGroups[2] = threadGroup_B;
        ThreadGroup threadGroup_B1 = new ThreadGroup(threadGroup_B,"Thread Group B1");
        ThreadGroup threadGroup_B2 = new ThreadGroup(threadGroup_B,"Thread Group B2");

        ThreadGroup threadGroup_C = new ThreadGroup("Thread Group C");
        threadGroups[3] = threadGroup_C;

        Thread thread_one = new MyThread("Thread 01");
        threads[0] = thread_one;

        Thread thread_two = new MyThread(threadGroup_A,"Thread 02");
        threads[1] = thread_two;

        Thread thread_three = new MyThread(threadGroup_A,"Thread 03");
        threads[2] = thread_three;

        Thread thread_four = new MyThread(threadGroup_C, "Thread 04");
        threads[3] = thread_four;

        Thread thread_five = new MyThread(threadGroup_B1, "Thread 05");
        threads[4] = thread_five;

        Thread thread_six = new MyThread(threadGroup_B1, "Thread 06");
        threads[5] = thread_six;

        Thread thread_seven = new MyThread(threadGroup_B2, "Thread 07");
        threads[6] = thread_seven;

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        int activeThreadCount = threadGroups[0].activeCount();
        //there can be more active threads than we assume,
        //so as a safe practice the tread count will be multiplied
        Thread[] activeThreadsInAllGroups = new Thread[activeThreadCount*2];

        threadGroups[0].enumerate(activeThreadsInAllGroups);

        System.out.println("Retrieve active Threads using enumerate(Thread[] threadList)");
        for (int i = 0; i < activeThreadsInAllGroups.length; i++) {

            if(activeThreadsInAllGroups[i] != null) {
                System.out.println(activeThreadsInAllGroups[i].getName());
            }
        }
        System.out.println();

        int activeThreadCount_02 = threadGroups[0].activeCount();
        Thread[] activeThreadsWithoutSubGroups = new Thread[activeThreadCount_02*2];
        threadGroups[0].enumerate(activeThreadsWithoutSubGroups, true);

        System.out.println("Retrieve active Threads using enumerate(Thread[] threadList, boolean recurse)");
        for (int i = 0; i < activeThreadsWithoutSubGroups.length; i++) {

            if(activeThreadsWithoutSubGroups[i] != null) {
                System.out.println(activeThreadsWithoutSubGroups[i].getName());
            }
        }

    }
}
