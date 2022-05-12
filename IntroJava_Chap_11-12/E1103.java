
/* ((Subclasses of Account) In Programming Exercise 9.7, the Account class was
defined to model a bank account. An account has the properties account number,
balance, annual interest rate, and date created, and methods to deposit and withdraw
funds. Create two subclasses for checking and saving accounts. A checking
account has an overdraft limit, but a savings account cannot be overdrawn.
Draw the UML diagram for the classes and implement them. Write a test program
that creates objects of Account, SavingsAccount, and CheckingAccount and
invokes their toString() methods.
*/
import java.util.Date;
public class E1103 {
    public static void main(String[] args) {
        CheckingAccount jack = new CheckingAccount(1122, 2000, 500);
        Account.changeInterestRate(4.5);
        jack.withdraw(2600);
        jack.withdraw(2500);
        jack.deposit(3000);
        System.out.println(jack.toString());

    }
}

class SavingsAccount extends Account{

    public SavingsAccount(){
        super();
    }

    public SavingsAccount(int id, double balance){
        super(id, balance);
    }

    @Override
    public void withdraw(double amount){
        if (getAccountBlance() - amount >= 0) super.withdraw(amount);
        else System.out.println("Balance insufficient.");
    }
    
}

class CheckingAccount extends Account{
    private double overdraftLimit;

    public CheckingAccount(){
        super();
        overdraftLimit = 200;
    }

    public CheckingAccount(int id, double balance){
        super(id, balance);
    }

    public CheckingAccount(int id, double balance, double overdraftLimit){
        super(id, balance);
        setOverdraftLimit(overdraftLimit);
    }

    public void setOverdraftLimit(double overdraftLimit){
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit(){
        return overdraftLimit;
    }

    @Override
    public void changeAccountBalance(double balance) {
        System.out.println("Balance cannot be changed directly.");;
    }

    @Override
    public void withdraw(double amount){
        if (getAccountBlance() - amount >= 0 - overdraftLimit) super.withdraw(amount);
        else System.out.println("Amount $" + amount + "exceeds overdraft limit.");
    }

    @Override
    public String toString(){
        return super.toString() + "\nOverdraft limit: $" + overdraftLimit;
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
        System.out.println("Withdraw fund: $" + amount);
    }

    public void deposit(double amount) {
        balance +=amount;
        System.out.println("Deposit fund: $" + amount);
    }

    @Override
    public String toString(){
        return "Account overview:\nID: " + id + "\nBalance: $" + balance + "\nDate created: " + dateCreated;
    }
   
}
