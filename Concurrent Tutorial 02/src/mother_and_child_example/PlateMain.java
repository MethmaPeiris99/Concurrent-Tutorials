package mother_and_child_example;

public class PlateMain {

    public static void main(String[] args) {

        Plate plate = new Plate("Rice");

        Runnable mother = new Mother(plate);
        Runnable child = new Child(plate);

        Thread motherThread = new Thread(mother, "Mother Thread");
        Thread childThread = new Thread(child, "Child Thread");

        motherThread.start();
        childThread.start();
    }
}
