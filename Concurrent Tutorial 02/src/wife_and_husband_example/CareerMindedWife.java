package wife_and_husband_example;

public class CareerMindedWife implements Runnable{

    private BankAccount account;
    private String name;

    public CareerMindedWife(BankAccount account, String name){
        this.account = account;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            account.deposit(10000, this.getName());
//            System.out.println(this.getName()+ " deposits money to the account " +
//                    account.getAccountNumber()+ " and the account balance is "+account.getAccountBalance());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getName(){
        return name;
    }
}
