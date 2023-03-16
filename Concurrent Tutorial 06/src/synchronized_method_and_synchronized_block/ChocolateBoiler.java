package synchronized_method_and_synchronized_block;

public class ChocolateBoiler {

    //Non-lazy initialization is a bad practice which caused to memory leak
    //private static ChocolateBoiler instance = new synchronized_method_and_synchronized_block.ChocolateBoiler(); //Non-lazy initialization

    //Lazy initialization is creating an instance only if it's needed
    private static  ChocolateBoiler instance; //Lazy initialization

    public ChocolateBoiler(){}

    //synchronized method => declare the method as synchronized
    /*public static synchronized synchronized_method_and_synchronized_block.ChocolateBoiler getInstance(){
        if(instance == null){ //Start of critical section
            //Object creation part should be synchronized
            instance = new synchronized_method_and_synchronized_block.ChocolateBoiler();
        }//End of critical section
        return instance;
    }*/

    public static ChocolateBoiler getInstance(){
        if(instance == null){
            //Example for synchronized block
            synchronized(ChocolateBoiler.class){ //class is an attribute
                if(instance == null){ //check again if the instance is null,
                    // double check is important to verify that the object is not created
                    instance = new ChocolateBoiler();
                }
            }
        }
        return instance;
    }

    //fill()
    //boil()
    //empty()


}
