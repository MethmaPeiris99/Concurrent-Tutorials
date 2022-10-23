import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()); //currentThread() will refer to the current thread that has been running
        System.out.println("Priority :"+Thread.currentThread().getPriority()); //getPriority() will return the priority of the thread

        Scanner sc = new Scanner(System.in);
        sc.nextInt();

        Thread t1 = new Number("Number 01");
        Thread t2 = new Number("Number 02");
//        Thread t3 = new Alphabet("Alphabet");

        Runnable r1 = new Alphabet();
        Thread t3 = new Thread(r1, "Alphabet 01");

        Runnable r2 = new Alphabet();
        Thread t4 = new Thread(r2, "Alphabet 02");

//        t1.start();
//        t2.start();
//        t3.start();
//        t4.start();

        Runnable r3 = new Clock();
        Thread t5 = new Thread(r3, "Clock Thread");

        t5.start();
    }
}
