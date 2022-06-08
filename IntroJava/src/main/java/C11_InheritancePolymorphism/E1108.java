package C11_InheritancePolymorphism;
/* (New Account class) An Account class was specified in Programming Exercise 9.7.
Design a new Account class as follows:
■■ Add a new data field name of the String type to store the name of the customer.
■■ Add a new constructor that constructs an account with the specified name, id, and balance.
■■ Add a new data field named transactions whose type is ArrayList that
stores the transaction for the accounts. Each transaction is an instance of the
Transaction class, which is defined as shown in Figure 11.6.
*/

public class E1108 {
    public static void main(String[] args) {
        AccountNew jack = new AccountNew("Jack", 1122, 1000) ;
        AccountNew.changeInterestRate(1.5);
        jack.withdraw(40, "grocery");
        jack.withdraw(300, "newspaper");
        jack.deposit(50, "luck");
        printAccount(jack);

    }
    public static void printAccount(AccountNew a){
        System.out.println(a.toString());
        System.out.println("Transaction records:");
        for (int i = 0; i < a.getTransaction().size(); i++) {
            System.out.println(a.getTransaction().get(i).toString());
        }
    }
}
