package single_slot_producer_consumer;

public class Producer extends Thread{
    private MailBox mailBox;

    public Producer(String name, MailBox mailBox){
        super(name); //Setting the producer's name as the thread name
        this.mailBox = mailBox;
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            mailBox.put(i);
        }
    }
}
