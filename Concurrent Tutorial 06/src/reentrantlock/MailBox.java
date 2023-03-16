package reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MailBox{

    private int number;
    private boolean isAvailable = false;

    ReentrantLock lock = new ReentrantLock(true); //Faired locking

    Condition available = lock.newCondition(); //Producer's condition
    Condition notAvailable = lock.newCondition(); //Consumer's condition

    public void put(int number){
        lock.lock(); //Start of critical section

        //------------------- Critical Section -------------------//
        while (isAvailable){
            try {
                available.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        this.number = number;
        System.out.println(Thread.currentThread().getName()+" produces "+number);
        isAvailable = true;
        notAvailable.signalAll();

        lock.unlock(); //End of critical section
    }

    public int get(){
        try {
            lock.lock();

            while (!isAvailable) {
                try {
                    notAvailable.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(Thread.currentThread().getName()+" consumes "+number);
            isAvailable = false;
            available.signalAll();
            return number;
        }
        finally {
            lock.unlock(); //Way to put unlock as the last statement
        }
    }
}
