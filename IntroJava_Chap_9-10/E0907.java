
/* ((The Account class) Design a class named Account that contains:
■■ A private int data field named id for the account (default 0).
■■ A private double data field named balance for the account (default 0).
■■ A private double data field named annualInterestRate that stores the current
interest rate (default 0). Assume that all accounts have the same interest rate.
■■ A private Date data field named dateCreated that stores the date when the
account was created.
■■ A no-arg constructor that creates a default account.
■■ A constructor that creates an account with the specified id and initial balance.
■■ The accessor and mutator methods for id, balance, and annualInterestRate.
■■ The accessor method for dateCreated.
■■ A method named getMonthlyInterestRate() that returns the monthly
interest rate.
■■ A method named getMonthlyInterest() that returns the monthly interest.
■■ A method named withdraw that withdraws a specified amount from the
account.
■■ A method named deposit that deposits a specified amount to the account.
Draw the UML diagram for the class then implement the class. (Hint: The method
getMonthlyInterest() is to return monthly interest, not the interest rate.
Monthly interest is balance * monthlyInterestRate. monthlyInterestRate
is annualInterestRate / 12. Note annualInterestRate is a percentage,
for example 4.5%. You need to divide it by 100.)
Write a test program that creates an Account object with an account ID of 1122, a
balance of $20,000, and an annual interest rate of 4.5%. Use the withdraw method
to withdraw $2,500, use the deposit method to deposit $3,000, and print the balance,
the monthly interest, and the date when this account was created.
*/
import java.util.Date;
public class E0907 {
    public static void main(String[] args) {
        Account jack = new Account(1122, 20000);
        Account.changeInterestRate(4.5);
        jack.withdraw(2500);
        jack.deposit(3000);
        System.out.println("Balance: " + jack.getAccountBlance() + " Monthly interest: " + jack.getMonthlyInterest()
        + " Date: " + jack.getDate());

    }
}

class Account {
    //Data fields
    private int id ;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated = new Date();

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
