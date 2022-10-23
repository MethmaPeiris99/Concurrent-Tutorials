public class Number extends Thread{

    public Number(String name){
        super(name);
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+ " Priority :"+Thread.currentThread().getPriority());

        for(int i = 0; i <= 100; i++){
            System.out.println(Thread.currentThread().getName()+ ":" +i);

            //Threads can be interrupted while they're a sleep therefore error should be handled
            try{
                Thread.sleep(100);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
