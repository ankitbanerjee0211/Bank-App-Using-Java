import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your name, initial deposit amount and new password to create account");
        SBIAccount sbiAccount1 = new SBIAccount(in.next(), in.nextInt(), in.next());

        System.out.println("Your account has been created successfully with account number: " + sbiAccount1.getAccountNo());

        while(true){
            System.out.println("""
                
                Transaction Options: Please enter one of the options as following
                -----------------------------------------------------------------
                Press 1 to deposit money
                Press 2 to withdraw money
                Press 3 to get current balance
                Press 4 to get interest amount
                Press 0 to exit OR end the session
                ----------------------------------------------------------------
                """);

            int option = in.nextInt();
            if(option == 0){
                System.out.println("Thank You!");
                break;
            } else if(option == 1){
                System.out.print("Enter amount to deposit: ");
                System.out.println(sbiAccount1.depositMoney(in.nextInt()));
            } else if(option == 2){
                System.out.print("Enter amount to withdraw: ");
                int amount = in.nextInt();
                System.out.print("Enter password: ");
                String password = in.next();
                System.out.println(sbiAccount1.withdraw(amount, password));
            } else if(option == 3){
                System.out.println("Current balance: " + sbiAccount1.getBalance());
            } else if(option == 4){
                System.out.print("Enter time in years:");
                System.out.println("Current Interest: " + sbiAccount1.calculateInterest(in.nextInt()));
            } else{
                System.out.println("Invalid Option selected");
            }
        }
    }
}