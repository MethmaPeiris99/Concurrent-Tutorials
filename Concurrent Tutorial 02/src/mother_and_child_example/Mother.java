package mother_and_child_example;

public class Mother implements Runnable{

    private Plate plate;
    public Mother(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            plate.putFood("Rice");
            System.out.println(Thread.currentThread().getName()+ " is serving the food");

//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
