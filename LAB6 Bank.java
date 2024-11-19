class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    public Account(String customerName, int accountNumber, String accountType, double initialBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance; // Corrected to use initialBalance
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount; // Simplified
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void displayBalance() {
        System.out.println("Account Balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

class SavAcct extends Account {
    double interestRate;

    public SavAcct(String customerName, int accountNumber, double balance, double interestRate) {
        super(customerName, accountNumber, "Savings", balance);
        this.interestRate = interestRate;
    }

    public void computeInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        System.out.println("Interest added: $" + interest);
    }
}

class CurAcct extends Account {
    double minimumBalance;
    double serviceCharge;

    public CurAcct(String customerName, int accountNumber, double balance, double minimumBalance, double serviceCharge) {
        super(customerName, accountNumber, "Current", balance);
        this.minimumBalance = minimumBalance;
        this.serviceCharge = serviceCharge;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
            if (balance < minimumBalance) {
                balance -= serviceCharge;
                System.out.println("Service charge imposed: $" + serviceCharge);
            }
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class Bank {
    public static void main(String[] args) {
        SavAcct S = new SavAcct("Hitha Harish", 2152, 10000, 5);
        S.computeInterest();
        S.deposit(1000);
        S.displayBalance();
        S.withdraw(500);
        S.displayBalance();

        System.out.println();

        CurAcct C = new CurAcct("Jane", 102, 3000, 1000, 50);
        C.deposit(2000);
        C.displayBalance();
        C.withdraw(2000);
        C.withdraw(2500);  
        C.displayBalance();
    }
}



OUTPUT:
Interest added: $500.0
Deposited: $1000.0
Account Balance: $11500.0
Withdrew: $500.0
Account Balance: $11000.0

Deposited: $2000.0
Account Balance: $5000.0
Withdrew: $2000.0
Withdrew: $2500.0
Service charge imposed: $50.0
Account Balance: $450.0

