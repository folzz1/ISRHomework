package org.example;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account[] accounts = new Account[10];


        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i + 1, 10_000.0, 6.5, new Date());
        }

        while (true) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();

            Account account = null;
            for (Account acc : accounts) {
                if (acc.getId() == id) {
                    account = acc;
                    break;
                }
            }

            if (account != null) {
                System.out.println("Welcome to the banking system!");
                while (true) {
                    System.out.println("Main menu:");
                    System.out.println("1. View balance");
                    System.out.println("2. Withdraw money");
                    System.out.println("3. Deposit money");
                    System.out.println("4. Exit");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Current balance: " + account.getBalance());
                            break;
                        case 2:
                            System.out.print("Enter amount to withdraw: ");
                            double amount = scanner.nextDouble();
                            account.withdraw(amount);
                            System.out.println("New balance: " + account.getBalance());
                            break;
                        case 3:
                            System.out.print("Enter amount to deposit: ");
                            amount = scanner.nextDouble();
                            account.deposit(amount);
                            System.out.println("New balance: " + account.getBalance());
                            break;
                        case 4:
                            System.out.println("Goodbye!");
                            break;
                    }
                    if (choice == 4) {
                        break;
                    }
                }
            } else {
                System.out.println("Invalid ID. Please try again.");
            }
        }
    }
}
