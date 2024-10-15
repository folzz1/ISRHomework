package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account(1233, 1100.0, 7.5, "Семён");

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Пополнить счет");
            System.out.println("2. Снять деньги");
            System.out.println("3. Вывести информацию о счете");
            System.out.println("4. Выход");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите сумму для пополнения: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Счет пополнен на " + depositAmount + ". Новый баланс: " + account.getBalance());
                    break;

                case 2:
                    System.out.print("Введите сумму для снятия: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= account.getBalance()) {
                        account.withdraw(withdrawAmount);
                        System.out.println("Снято " + withdrawAmount + ". Новый баланс: " + account.getBalance());
                    } else {
                        System.out.println("Недостаточно средств для снятия.");
                    }
                    break;

                case 3:
                    System.out.println("Имя владельца: " + account.getName());
                    System.out.println("Процентная ставка: " + account.getAnnualInterestRate());
                    System.out.println("Баланс: " + account.getBalance());
                    System.out.println("Транзакции:");
                    account.printTransactions();
                    break;

                case 4:
                    System.out.println("Выход из программы.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }
}