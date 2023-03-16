package reentrantlock;

public class Main {

    public static void main(String[] args) {

        MailBox mailBox = new MailBox();

        Thread producer = new Producer("Producer", mailBox);
        Thread consumer = new Consumer("Consumer", mailBox);

        producer.start();
        consumer.start();
    }
}
