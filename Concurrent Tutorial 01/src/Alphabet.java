public class Alphabet implements Runnable{

//    public Alphabet(String name){
//        super(name);
//    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()+ " Priority :"+Thread.currentThread().getPriority());

        for(int i=65; i<=90; i++){
            System.out.println(Thread.currentThread().getName()+":"+((char)i));
        }

        for(int i=97; i<=122; i++){
            System.out.println(Thread.currentThread().getName()+":"+((char)i));
        }
    }

}
