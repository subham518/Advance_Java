package javabasics.jan19;
import java.util.Scanner;

class ATM {
    private double balance = 500;

    public void display() {
        System.out.println("Balance: " + balance);
    }

    public void deposit(Scanner s) {
        System.out.print("Enter amount to deposit: ");
        double amount = s.nextDouble();

        if (amount <= 0) {
            System.out.println("Enter a valid amount!");
            return;
        }

        balance += amount;
        System.out.println("Updated Balance: " + balance);
    }

    public void withdraw(Scanner s) {
        System.out.print("Enter amount to withdraw: ");
        double amount = s.nextDouble();

        if (amount <= 0) {
            System.out.println("Enter a valid amount!");
            return;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Updated Balance: " + balance);
        }
    }
}

public class ATMApp {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ATM obj = new ATM();

        System.out.println("Welcome to the Mini ATM!!");
        System.out.print("Want to start? (y/n): ");
        char ch = s.next().charAt(0);

        while (ch == 'y' || ch == 'Y') {
            System.out.println("\nChoose option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");

            int choice = s.nextInt();

            switch (choice) {
                case 1: obj.display();break;
                case 2: obj.deposit(s);break;
                case 3: obj.withdraw(s);break;
                case 4: System.out.println("Thank you for using Mini ATM!");s.close();return;
                default: System.out.println("Invalid choice!");
            }

            System.out.print("\nWant to continue? (y/n): ");
            ch = s.next().charAt(0);
        }

        System.out.println("Thank you for using Mini ATM!");
        s.close();
    }
}
