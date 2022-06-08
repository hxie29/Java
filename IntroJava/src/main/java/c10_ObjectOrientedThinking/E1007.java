package c10_ObjectOrientedThinking;
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

import java.util.Scanner;
import c09_ObjectsClasses.Account;
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
            switch (choice) {
                case 1 -> System.out.println("The balance is " + accounts[id].getAccountBalance());
                case 2 -> {
                    System.out.println("Enter an amount to withdraw:");
                    double amount = input.nextDouble();
                    accounts[id].withdraw(amount);
                }
                case 3 -> {
                    System.out.println("Enter an amount to deposit");
                    double amount = input.nextDouble();
                    accounts[id].deposit(amount);
                }
                case 4 -> accountExit = true;
                case 5 -> {
                    accountExit = true;
                    sysExit[0] = true;
                }
            }
        }
    }
}

