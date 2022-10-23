package wife_and_husband_example;

public class BankAccountMain {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(0.0, "Account001");

        Runnable careerMindedWife = new CareerMindedWife(account, "Rich Wife");
        Runnable houseBasedHusband = new HouseBasedHusband(account, "Lazy Husband");

        Thread careerMindedWifeThread = new Thread(careerMindedWife, careerMindedWife.getClass().getName());
        Thread houseBasedHusbandThread = new Thread(houseBasedHusband, houseBasedHusband.getClass().getName());

        careerMindedWifeThread.start();
        houseBasedHusbandThread.start();
    }
}
