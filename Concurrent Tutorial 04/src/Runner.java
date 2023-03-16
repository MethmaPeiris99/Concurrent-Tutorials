public class Runner extends Thread{

    public volatile boolean terminate = false; //Used to terminate the thread

    public int tick = 1; //Used to specify the number of runs that a particular thread can run
    // Used to draw the line and strings in the Applet

    public Runner(int id){
        super("Runner" + id);
    }

    @Override
    public void run(){
        while (tick < 400000 && !terminate){
            tick++;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
