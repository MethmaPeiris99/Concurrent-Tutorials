package wife_and_husband_example;

public class HouseBasedHusband implements Runnable{

    private BankAccount account;
    private String name;

    public HouseBasedHusband(BankAccount account, String name) {
        this.account = account;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            try {
                account.withdraw(10000, this.getName());
//                System.out.println(this.getName()+ " withdraws money from the account " +
//                        account.getAccountNumber()+ " and the account balance is "+account.getAccountBalance());

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

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
