package mother_and_child_example;

public class Child implements Runnable{
    private Plate plate;
    public Child(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            plate.getFood();
            System.out.println(Thread.currentThread().getName()+" is consuming the food");

//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
