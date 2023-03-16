package single_slot_producer_consumer;

public interface MailBox {

    public void put(int number);
    public int get();
}
