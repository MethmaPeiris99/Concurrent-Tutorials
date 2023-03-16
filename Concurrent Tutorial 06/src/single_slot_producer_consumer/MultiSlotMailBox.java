package single_slot_producer_consumer;

import java.util.LinkedList;
import java.util.Queue;

public class MultiSlotMailBox implements MailBox{

    private static Queue<Integer> numbers = new LinkedList<>();
    private static final int MAXIMUM_SIZE = 10;

    @Override
    public synchronized void put(int number) {
        while (isFull()){ //check the availability
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numbers.add(number);
        System.out.println(Thread.currentThread().getName()+" produces "+number);
        notifyAll();
    }

    @Override
    public synchronized int get() {
        while (isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        int number = numbers.poll();
        System.out.println(Thread.currentThread().getName()+" consumes "+ number);
        return number;
    }

    private boolean isFull(){
        return numbers.size() == MAXIMUM_SIZE;
    }

    private boolean isEmpty(){
        return numbers.isEmpty();
    }
}
