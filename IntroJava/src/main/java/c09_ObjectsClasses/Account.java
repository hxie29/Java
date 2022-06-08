package c09_ObjectsClasses;

import java.util.Date;

public class Account {
    //Data fields
    private int id ;
    private double balance;
    private static double annualInterestRate;
    private final Date dateCreated = new Date();

    // Constructor
    public Account(){

    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getAccountID() {
        return id;
    }

    public double getAccountBalance() {
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

    public double getMonthlyInterest() {
        return balance * annualInterestRate / 100 / 12;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void deposit(double amount) {
        balance +=amount;
    }
}
