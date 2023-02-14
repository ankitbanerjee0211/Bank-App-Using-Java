import java.util.UUID;

public class SBIAccount implements BankInterface{

    private String name;
    private String accountNo; // to use UUID for random unique name
    private double balance;
    private String password;
    private double rateOfInterest;

    // alt + ins => generate getters and setters, constructors
    public SBIAccount(String name, int balance, String password){
        this.name = name;
        this.balance = balance;
        this.password = password;

        this.rateOfInterest = 6.6;
        this.accountNo = String.valueOf(UUID.randomUUID());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        accountNo = accountNo;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public String depositMoney(int amount) {
        this.balance += amount;
        return "Amount of " + amount + " has been credited to your account. Current available balance " + getBalance() + ".";
    }

    @Override
    public String withdraw(int amount, String enteredPassword) {
        if(password.equals(enteredPassword)){
            if(balance > amount){
                this.balance -= amount;
                return "Amount of " + amount + " has been debited from your account. Current available balance " + getBalance() + ".";
            } else{
                return "Insufficient Account Balance";
            }
        } else {
            return "Password Mismatch";
        }

    }

    @Override
    public double calculateInterest(int time) {
        return (balance*rateOfInterest*time)/100.0;
    }
}
