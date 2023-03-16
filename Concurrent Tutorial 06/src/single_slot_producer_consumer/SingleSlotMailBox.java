package single_slot_producer_consumer;

//Monitor class
public class SingleSlotMailBox implements MailBox{

    private static int number; //Shared variable
    private static boolean available = false; //State variable used for tracking purpose

    //Code inside put() and get() methods are critical sections
    @Override
    public synchronized void put(int number) {

        while (available){ //Producer should wait until it's unavailable
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = true;
        this.number = number; //this keyword is used to ensure that the 'number' instance variable is obtained
        notifyAll();
    }

    @Override
    public synchronized int get() {
        while (!available){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return number;
        //unreachable
    }
}
