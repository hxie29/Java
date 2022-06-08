package c11_InheritancePolymorphism;
/* ((Subclasses of Account) In Programming Exercise 9.7, the Account class was
defined to model a bank account. An account has the properties account number,
balance, annual interest rate, and date created, and methods to deposit and withdraw
funds. Create two subclasses for checking and saving accounts. A checking
account has an overdraft limit, but a savings account cannot be overdrawn.
Draw the UML diagram for the classes and implement them. Write a test program
that creates objects of Account, SavingsAccount, and CheckingAccount and
invokes their toString() methods.
*/

public class E1103 {
    public static void main(String[] args) {
        CheckingAccount jack = new CheckingAccount(1122, 2000, 500);
        AccountNew.changeInterestRate(4.5);
        jack.withdraw(2600, "1");
        jack.withdraw(2500, "2");
        jack.deposit(3000, "cash");
        System.out.println(jack);

    }
}