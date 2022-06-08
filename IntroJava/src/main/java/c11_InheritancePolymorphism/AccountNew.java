package c11_InheritancePolymorphism;

import java.util.ArrayList;
import java.util.Date;

class AccountNew {
    //Data fields
    private int id;
    private String name;
    private double balance;
    private final ArrayList<Transaction> transactions = new ArrayList<>();
    private static double annualInterestRate;
    private final Date dateCreated = new Date();

    // Constructor
    public AccountNew() {
    }

    public AccountNew(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public AccountNew(String name, int id, double balance) {
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public int getAccountID() {
        return id;
    }

    public double getAccountBlance() {
        return balance;
    }

    public double getInterestRate() {
        return annualInterestRate;
    }

    public void changeAccountId(int id) {
        this.id = id;
    }

    public void changeAccountBalance(double balance) {
        this.balance = balance;
    }

    public static void changeInterestRate(double interestRate) {
        annualInterestRate = interestRate;
    }

    public String getDate() {
        return dateCreated.toString();
    }

    public ArrayList<Transaction> getTransaction() {
        return transactions;
    }

    public double getMonthlyInterest() {
        return balance * annualInterestRate / 100 / 12;
    }

    public void withdraw(double amount, String description) {
        balance -= amount;
        transactions.add(new Transaction('W', amount, balance, description));
        System.out.println("Withdraw fund: $" + amount);
    }

    public void deposit(double amount, String description) {
        balance += amount;
        transactions.add(new Transaction('D', amount, balance, description));
        System.out.println("Deposit fund: $" + amount);
    }

    @Override
    public String toString() {
        return "Account overview:\nName: " + name + "\nID: " + id + "\nBalance: $" + balance + "\nDate created: " + dateCreated;
    }

}
