package wife_and_husband_example;

public class BankAccount{

    private double accountBalance;
    private String accountNumber;

    public BankAccount(double accountBalance, String accountNumber){
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    public synchronized double deposit(double amount, String wifeName){
        //If the balance is enough (at least 10,000) then the wife thread will put into an inactive state
        while (accountBalance >= 10000){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        accountBalance += amount;
        System.out.println(wifeName+ " deposits money to the account " +
                this.accountNumber+ " and the account balance is "+this.accountBalance);
        //After deposit wife thread will notify the husband thread to withdraw money
        notifyAll();
        return accountBalance;
    }

    public synchronized double withdraw(double amount, String husbandName) {
        //If the balance is not enough then the husband thread will put into an inactive state
        while (accountBalance < 10000){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(amount <= accountBalance){
            accountBalance -= amount;
            System.out.println(husbandName+ " withdraws money from the account " +
                    this.accountNumber+ " and the account balance is "+this.accountBalance);
            //After withdrawal husband thread will notify the wife thread to deposit money
            notifyAll();
        }
        else {
            throw new IllegalArgumentException("Insufficient account balance!");
        }
        return accountBalance;
    }

    public synchronized double getAccountBalance(){
        return accountBalance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }
}
