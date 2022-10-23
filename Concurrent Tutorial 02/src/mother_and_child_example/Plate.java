package mother_and_child_example;

// Monitor
public class Plate {
    private String food;
    private boolean foodAvailable = false;
    public Plate(String food) {
        this.food = food;
    }
    public synchronized String getFood(){
        while (!foodAvailable) {
            try {
                System.out.println(Thread.currentThread().getName()+ " starts to wait");
                wait(100);
                System.out.println(Thread.currentThread().getName()+ " 's waiting ends");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //mother_and_child_example.Child is consuming the food
        this.foodAvailable = false;
        notifyAll(); //mother_and_child_example.Child will notify the mother to serve the food
        return food;
    }
    public synchronized void putFood(String food){
        while (foodAvailable){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //mother_and_child_example.Mother serves the food
        this.food = food;
        this.foodAvailable = true;
        notifyAll(); //mother_and_child_example.Mother will notify the child to consume the food
    }
}
