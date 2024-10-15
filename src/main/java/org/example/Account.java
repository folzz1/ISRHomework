package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private String name;
    private ArrayList<Transaction> transactions;

    public Account(int id, double balance, double annualInterestRate, String name) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
        this.name = name;
        this.transactions = new ArrayList<>();
    }

    public Account() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getName() {
        return name;
    }

    public void withdraw(double amount) {
        balance -= amount;
        transactions.add(new Transaction('w', amount, balance, "Снятие средств"));
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction('d', amount, balance, "Внесение средств"));
    }

    public void printTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getType() + ": " + transaction.getAmount() + ", Баланс: " + transaction.getBalance() + ", Дата: " + transaction.getDate() + ", Описание: " + transaction.getDescription());
        }
    }

    public double getMonthlyInterestRate() {
        return (annualInterestRate / 100) * balance / 12;
    }
}