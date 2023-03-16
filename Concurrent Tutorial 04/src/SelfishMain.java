public class SelfishMain {

    private final static int NUMBER_OF_SELFISH_THREADS = 2;

    public static void main(String[] args) {
        SelfishThread selfishThreads[] = new SelfishThread[NUMBER_OF_SELFISH_THREADS];

        for (int i = 0; i < NUMBER_OF_SELFISH_THREADS; i++) {
            selfishThreads[i] = new SelfishThread(i);
            selfishThreads[i].setPriority(2);
            selfishThreads[i].start();
        }

//        for (int i = 0; i < NUMBER_OF_SELFISH_THREADS; i++) {
//            selfishThreads[i].start();
//        }
    }
}
