/*
(Game: ATM machine) Use the Account class created in Programming Exercise
9.7 to simulate an ATM machine. Create 10 accounts in an array with id 0,
1, . . . , 9, and an initial balance of $100. The system prompts the user to enter
an id. If the id is entered incorrectly, ask the user to enter a correct id. Once an
id is accepted, the main menu is displayed as shown in the sample run. You can
enter choice 1 for viewing the current balance, 2 for withdrawing money, 3 for
depositing money, and 4 for exiting the main menu. Once you exit, the system
will prompt for an id again. Thus, once the system starts, it will not stop.
*/

import java.util.Date;
import java.util.Scanner;
public class E1007 {
    public static void main(String[] args) {
        Account[] accounts = new Account[10];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }
        boolean[] sysExit = new boolean[1];
        while(!sysExit[0]){
            int id = enterId();
            menu(id, accounts, sysExit);
        }
        
    }

    public static int enterId(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Enter an id:");
            int id = input.nextInt();
            if (id <= 9 && id >= 0) return id;
            else System.out.println("Incorrect input.");
        }
    }
    
    public static void menu(int id, Account[] accounts, boolean[]sysExit) {
        Scanner input = new Scanner(System.in);
        boolean accountExit = false;
        while(!accountExit){
            System.out.println("Main menu");
            System.out.println("1: check balance \n2: withdraw \n3: deposit \n4: exit account\n5: exit system \nEnter a choice:");
            int choice = input.nextInt();
            switch(choice) {
                case 1: {
                    System.out.println("The balance is " + accounts[id].getAccountBalance()); 
                    break;
                }
                case 2: {
                    System.out.println("Enter an amount to withdraw:");
                    double amount = input.nextDouble();
                    accounts[id].withdraw(amount);
                    break;
                }
                case 3: {
                    System.out.println("Enter an amount to deposit"); 
                    double amount = input.nextDouble();
                    accounts[id].deposit(amount);
                    break;
                }
                case 4:{
                    accountExit = true; 
                    break;
                }
                case 5:{
                    accountExit = true; 
                    sysExit[0] = true;
                    break;
                }
            }
        }
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
