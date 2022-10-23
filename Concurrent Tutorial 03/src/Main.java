public class Main {

    public static void main(String[] args) {

        Runnable object_01 = new Thread_01();
        Runnable object_02 = new Thread_01();

        Thread thread_01 = new Thread(object_01, "Thread 01");
        Thread thread_02 = new Thread(object_02, "Thread 02");

        /* Return NEW for both threads */
        System.out.println("Thread 01 current state: "+ thread_01.getState());
        System.out.println("Thread 02 current state: "+ thread_02.getState());

        /* Return false for both threads, because the two threads are still in the NEW state */
        System.out.println("Is Thread 01 alive: "+ thread_01.isAlive());
        System.out.println("Is Thread 02 alive: "+ thread_02.isAlive());

        /* Return 5 for both threads, because the default priority of a thread is 5 */
        System.out.println("Thread 01 current priority: "+ thread_01.getPriority());
        System.out.println("Thread 02 current priority: "+ thread_02.getPriority());

        /* Return false for both threads, because the parent thread, "Thread_01" is non-daemon */
        System.out.println("Is Thread 01 a Daemon Thread: "+ thread_01.isDaemon());
        System.out.println("Is Thread 02 a Daemon Thread: "+ thread_02.isDaemon());

        thread_01.setDaemon(true); //Set thread_01 as a Daemon Thread
        System.out.println();
        System.out.println("---------- After setting the thread_01 as a Daemon Thread ----------");
        System.out.println("Is Thread 01 a Daemon Thread: "+ thread_01.isDaemon());
        thread_01.start();
        System.out.println("Thread 01 current state: "+ thread_01.getState());
        System.out.println("Thread 01 current priority: "+ thread_01.getPriority());

        /*-----------------------------------------   IMPORTANT! ----------------------------------------------------*
        * If thread_01 is set as a Daemon thread and then the programmer bring it to the RUNNABLE state using start(),
        * it won't come to the RUNNING state. It will remain in the RUNNABLE state
        * Because Daemon threads are low-priority threads. They won't get executed until some non-daemon thread comes to alive
        */

        try {
            thread_01.join(); //thread_02 won't start their execution until thread_01 got terminated
            System.out.println();
            System.out.println("---------- After join() is called by thread_01 ----------");
            System.out.println("thread_01 current state: "+ thread_01.getState());
            System.out.println("Is thread_01 alive: "+ thread_01.isAlive());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread_02.start();
        // thread_02.start();
        /*-----------------------------------------   IMPORTANT! ----------------------------------------------------*
        IllegalThreadStateException will throw because
        thread_02 is not in an appropriate state for the requested operation
        */

        /*-----------------------------------------   IMPORTANT! ----------------------------------------------------*
         * After the non-daemon thread_02 comes in to the RUNNABLE state, thread_01 will get executed
         */

        for (int i = 0; i <= 5; i++) {
            /*-----------------------------------------   IMPORTANT! ----------------------------------------------------*
             * Always main thread will come to this block because, it is the thread with the highest priority.
             * After the main thread (currently running thread puts into sleep thread_02 will get executed)
             */
            System.out.println(Thread.currentThread().getName()+ " Instance "+i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
