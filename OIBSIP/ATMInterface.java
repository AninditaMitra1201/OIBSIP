import java.util.Scanner;

class Account {
    private int accountId;
    private int balance;

    public Account(int accountId, int balance) {
        this.accountId = accountId;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void transfer(Account recipient, int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            recipient.balance += amount;
            System.out.println("Transfer successful. Current balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid transfer amount.");
        }
    }
}

class ATM {
    private Account account;
    private Scanner scanner = new Scanner(System.in);

    public ATM(Account account) {
        this.account = account;
    }

    public void showMainMenu() {
        System.out.println("ATM Interface");
        System.out.println("1. View Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
    }

    public void run() {
        System.out.print("Enter User ID: ");
        int userId = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

       
        Account userAccount = new Account(userId, 1000); 

        if (userAccount.getAccountId() == userId) {
            showMainMenu();

            int choice;
            do {
                System.out.print("Enter choice: ");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Balance: " + userAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        int withdrawAmount = scanner.nextInt();
                        userAccount.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        int depositAmount = scanner.nextInt();
                        userAccount.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient's account ID: ");
                        int recipientId = scanner.nextInt();
                        Account recipientAccount = new Account(recipientId, 0); 
                        System.out.print("Enter amount to transfer: ");
                        int transferAmount = scanner.nextInt();
                        userAccount.transfer(recipientAccount, transferAmount);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 5);
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Account sampleAccount = new Account(123456, 2000); 
        ATM atm = new ATM(sampleAccount);
        atm.run();
    }
}

