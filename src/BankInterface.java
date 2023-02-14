public interface BankInterface {
    double getBalance();
    String depositMoney(int amount);
    String withdraw(int amount, String enteredPassword);
    double calculateInterest(int time);
}
