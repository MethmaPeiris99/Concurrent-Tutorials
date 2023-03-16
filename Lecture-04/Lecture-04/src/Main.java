public class Main {
    public static void main(String[] args) {
        ThreadGroup groups[] = new ThreadGroup[6];
        Thread threads[] = new Thread[7];

        groups[0] = Thread.currentThread().getThreadGroup(); // main thread
        groups[1] = new ThreadGroup("ThreadGroup A");
        groups[2] = new ThreadGroup("ThreadGroup B");
        groups[3] = new ThreadGroup("ThreadGroup C");
        groups[4] = new ThreadGroup(groups[2], "ThreadGroup B1");
        groups[5] = new ThreadGroup(groups[2], "ThreadGroup B2");

        threads[0] = new MyThread(groups[0], "Thread 1");
        threads[1] = new MyThread(groups[1], "Thread 2");
        threads[2] = new MyThread(groups[1], "Thread 3");
        threads[3] = new MyThread(groups[3], "Thread 4");
        threads[4] = new MyThread(groups[4], "Thread 5");
        threads[5] = new MyThread(groups[4], "Thread 6");
        threads[6] = new MyThread(groups[5], "Thread 7");

        for (ThreadGroup tg: groups) {
            tg.setDaemon(true); // executing in background
        }

        for (Thread t: threads) {
            t.setPriority(10);  // set individual thread's priority to 10
            t.start();
        }

        // set individual thread's priority to 10 for first 3 threads in threads array
//        for (int i = 0; i < 3; i++) {
//            threads[i].setPriority(10);
//            threads[i].start();
//        }

        for (ThreadGroup tg: groups) {
            tg.setMaxPriority(8); // thread group's max priority set to 8
        }

        // set individual thread's priority to 10 for last 4 threads in threads array
//        for (int i = 3; i < threads.length; i++) {
//            threads[i].setPriority(10);
//            threads[i].start();
//        }

        for (int i = 0; i < threads.length; i++) {
            System.out.println("Threads Priority : " + threads[i].getPriority());
        }

        for (Thread t: threads) {
            System.out.println("Threads Priority : " + t.getPriority()); // print thread priority
        }

        // Interrupts all threads in this thread group
//        for (ThreadGroup tg: groups) {
//            tg.interrupt();
//        }

        int active = groups[0].activeCount();
        Thread threads2[] = new Thread[active*2];
        groups[0].enumerate(threads2); // Copies into the specified array every active thread in this thread group and its subgroups

        System.out.println("Using enumerate with thread array as parameter");
        for (int i = 0; i < threads2.length; i++) {
            if (threads2[i] != null) {
                System.out.println(threads2[i].getName());
                System.out.println("Is interrupted : " + threads2[i].isInterrupted());
            }
        }

        int active1 = groups[0].activeCount();
        Thread threads3[] = new Thread[active1*2];
        groups[0].enumerate(threads3, false); // Copies into the specified array every active thread in this thread group.

        System.out.println("Using enumarate with thread array and recursive as false");
        for (int i = 0; i < threads3.length; i++) {
            if (threads3[i] != null) {
                System.out.println(threads3[i].getName());
            }
        }

        int activeGroupCount = groups[0].activeGroupCount(); // Finds active thread groups in the
        // main thread group
        ThreadGroup activeThreadGroups[] = new ThreadGroup[activeGroupCount*2];
        groups[0].enumerate(activeThreadGroups); // Copies into the specified array references to every active subgroup in this thread group and its subgroups.

        System.out.println("Using enumarate with thread group array");
        for (int i = 0; i < activeThreadGroups.length; i++) {
            if (activeThreadGroups[i] != null) {
                System.out.println(activeThreadGroups[i].getName());
            }
        }

        int activeGroupCount2 = groups[0].activeGroupCount();
        ThreadGroup activeThreadGroups2[] = new ThreadGroup[activeGroupCount2*2];
        groups[0].enumerate(activeThreadGroups2, false); // Copies into the specified array references to every active subgroup in this thread group.

        // sets recursive as false,
        // so only the childern's of the main thread group will return
        // if we set to recursive as true, then childern's of the childern's will return

        System.out.println("Using enumarate with thread group array and recursive as false");
        for (int i = 0; i < activeThreadGroups2.length; i++) {
            if (activeThreadGroups2[i] != null) {
                System.out.println(activeThreadGroups2[i].getName());
            }
        }
    }
}