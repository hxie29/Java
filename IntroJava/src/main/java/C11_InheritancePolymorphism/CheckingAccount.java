package C11_InheritancePolymorphism;

class CheckingAccount extends AccountNew {
    private double overdraftLimit;

    public CheckingAccount() {
        super();
        overdraftLimit = 200;
    }

    public CheckingAccount(int id, double balance) {
        super(id, balance);
    }

    public CheckingAccount(int id, double balance, double overdraftLimit) {
        super(id, balance);
        setOverdraftLimit(overdraftLimit);
    }

    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void changeAccountBalance(double balance) {
        System.out.println("Balance cannot be changed directly.");
    }

    @Override
    public void withdraw(double amount, String description) {
        if (getAccountBlance() - amount >= 0 - overdraftLimit) super.withdraw(amount, description);
        else System.out.println("Amount $" + amount + "exceeds overdraft limit.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nOverdraft limit: $" + overdraftLimit;
    }

}
