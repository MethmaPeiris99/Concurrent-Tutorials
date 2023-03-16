package thread_group_intro;

public class ThreadGroups {

    public static void main(String[] args) {
        Thread thread_one = new Thread();

        System.out.println("Name of thread one: "+ thread_one.getName()); //Returns "Thread-thread_id" => Thread-0
        System.out.println("Name of the Thead Group of thread one: "+ thread_one.getThreadGroup().getName()); //Returns main

        ThreadGroup threadGroup_one = new ThreadGroup("Thread Group 01");

        System.out.println("Parent of thread group one: "+ threadGroup_one.getParent().getName() + "\n"); //Returns main

        Thread thread_two = new Thread(threadGroup_one, "Thread 02");

        System.out.println("Name of the Thead Group of thread two: "+
                thread_two.getThreadGroup().getName()); //Returns Thread Group 01

        System.out.println("Parent of the Thead Group of thread two: "+
                thread_two.getThreadGroup().getParent().getName()); //Returns main
    }
}

