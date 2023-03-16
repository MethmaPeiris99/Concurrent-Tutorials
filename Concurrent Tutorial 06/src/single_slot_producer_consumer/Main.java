package single_slot_producer_consumer;

public class Main {

    public static void main(String[] args) {

//        MailBox mailBox = new SingleSlotMailBox();
//
//        Thread producer = new Producer("Producer", mailBox);
//        Thread consumer = new Consumer("Consumer", mailBox);
//
//        producer.start();
//        consumer.start();

        MailBox mailBox = new MultiSlotMailBox();

        Thread producer1 = new Producer("Producer 01", mailBox);
        Thread consumer1 = new Consumer("Consumer 01", mailBox);

        Thread producer2 = new Producer("Producer 02", mailBox);
        Thread consumer2 = new Consumer("Consumer 02", mailBox);

        producer1.start();
        consumer1.start();
        producer2.start();
        consumer2.start();
    }
}
