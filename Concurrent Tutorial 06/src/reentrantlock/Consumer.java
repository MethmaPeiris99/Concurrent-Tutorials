package reentrantlock;

public class Consumer extends Thread{

    private MailBox mailBox;

    public Consumer(String name, MailBox mailBox){
        super(name);
        this.mailBox = mailBox;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            mailBox.get();
        }
    }
}
