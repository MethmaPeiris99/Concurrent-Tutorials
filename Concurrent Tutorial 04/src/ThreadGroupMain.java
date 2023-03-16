public class ThreadGroupMain {

    public static void main(String[] args) {
        System.out.println("Current thread name: "+ Thread.currentThread().getName()); //Returns "main"
        System.out.println("Thread group of current thread: "+ Thread.currentThread().getThreadGroup().getName()); //Returns "main"

        ThreadGroup threadGroup_01 = new ThreadGroup("TG01");
        System.out.println("Thread group of Thread 01: "+threadGroup_01.getParent().getName()); //Returns "main"

        ThreadGroup threadGroup_02 = new ThreadGroup(threadGroup_01, "TG02");
        System.out.println("Thread group of Thread 02: "+threadGroup_02.getParent().getName()); //Returns "main"

    }
}
