package c11_InheritancePolymorphism;

class SavingsAccount extends AccountNew {

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount, String description) {
        if (getAccountBlance() - amount >= 0) super.withdraw(amount, description);
        else System.out.println("Balance insufficient.");
    }

}
