public class SimpleThread extends Thread{
    final int oneSecond = 1000;

    public SimpleThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for (int i=0; i<10; i++){
            System.out.println(getName() + ":" + i);

            try{
                sleep((int) (Math.random() * oneSecond));
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(getName()+ ": TERMINATING");
    }
}
