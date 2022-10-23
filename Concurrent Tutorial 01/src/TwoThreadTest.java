public class TwoThreadTest {

    public static void main(String[] args) {

        Thread firstThread;
        Thread secondThread;

        firstThread = new SimpleThread("First Thread");
        secondThread = new SimpleThread("Second Thread");

        firstThread.start();
        secondThread.start();
    }
}
