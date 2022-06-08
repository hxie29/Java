package c11_InheritancePolymorphism;

import java.util.Date;

class Transaction {
    private final char type;
    private final Date date = new Date();
    private final double amount;
    private final double balance;
    private final String description;

    public Transaction(char type, double amount, double balance, String description) {
        this.type = type;
        this.amount = amount;
        this.balance = balance;
        this.description = description;
    }

    @Override
    public String toString() {
        return "\nDate: " + date + "\nTransaction type: " + type
                + "\nAmount: " + amount + "\nBlance after transaction: " + balance
                + "\nDescription: " + description + "\n";
    }
}
