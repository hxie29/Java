
/* (New Account class) An Account class was specified in Programming Exercise 9.7.
Design a new Account class as follows:
■■ Add a new data field name of the String type to store the name of the customer.
■■ Add a new constructor that constructs an account with the specified name, id, and balance.
■■ Add a new data field named transactions whose type is ArrayList that
stores the transaction for the accounts. Each transaction is an instance of the
Transaction class, which is defined as shown in Figure 11.6.
*/
import java.util.ArrayList;
import java.util.Date;

public class E1108 {
    public static void main(String[] args) {
        Account jack = new Account("Jack", 1122, 1000) ;
        Account.changeInterestRate(1.5);
        jack.withdraw(40, "Grocery");
        jack.withdraw(300, "Laptop");
        jack.deposit(50, "luck");
        printAccount(jack);

    }

    public static void printAccount(Account a){
        System.out.println(a.toString());
        System.out.println("Transaction records:");
        for (int i = 0; i < a.getTransaction().size(); i++) {
            System.out.println(a.getTransaction().get(i).toString());
        }
    }
}

class Account {
    //Data fields
    private int id ;
    private String name;
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private static double annualInterestRate;
    private Date dateCreated = new Date();

    // Constructor
    public Account(){
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Account(String name, int id, double balance) {
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

    public ArrayList getTransaction(){
        return transactions;
    }

    public double getMonthlyInterest() {
        return balance * annualInterestRate / 100 / 12;
    }

    public void withdraw(double amount, String description){
        balance -= amount;
        transactions.add(new Transaction('W', amount, balance, description));
        System.out.println("Withdraw fund: $" + amount);
    }
    
    public void deposit(double amount, String description) {
        balance +=amount;
        transactions.add(new Transaction('D', amount, balance, description));
        System.out.println("Deposit fund: $" + amount);
    }

    @Override
    public String toString(){
        return "Account overview:\nName: " + name + "\nID: " + id + "\nBalance: $" + balance + "\nDate created: " + dateCreated;
    }
   
}

class Transaction{
    private char type;
    private Date date = new Date();
    private double amount;
    private double balance;
    private String description;

    public Transaction(char type, double amount, double balance, String description){
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    @Override
    public String toString(){
        return "\nDate: " + date + "\nTransaction type: " + type 
                + "\nAmount: " + amount + "\nBlance after transaction: " + balance 
                + "\nDescription: " + description +"\n";
    }
}