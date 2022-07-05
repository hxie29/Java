package c32_Muiltithreading;

public class Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        int newBalance = balance + amount;

        try {
            Thread.sleep(5);
        } catch (InterruptedException ignored) {
        }
        balance = newBalance;
    }
}
