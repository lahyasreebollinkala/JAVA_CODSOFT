import java.util.ArrayList;

public class BankAccount {

    private String accountNumber;
    private String accountHolder;
    private double balance;
    private int pin;
    private boolean locked;
    private int failedAttempts;

    private ArrayList<String> history;

    public BankAccount(String accountNumber,
                       String accountHolder,
                       double balance,
                       int pin) {

        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.pin = pin;

        locked = false;
        failedAttempts = 0;

        history = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isLocked() {
        return locked;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public boolean validatePin(int enteredPin) {

        if(locked)
            return false;

        if(pin == enteredPin) {
            failedAttempts = 0;
            return true;
        }

        failedAttempts++;

        if(failedAttempts >= 3) {
            locked = true;
        }

        return false;
    }

    public void changePin(int newPin) {
        pin = newPin;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {

        if(amount > balance)
            return false;

        balance -= amount;
        return true;
    }

    public boolean transfer(double amount) {

        if(amount > balance)
            return false;

        balance -= amount;
        return true;
    }

    public void addHistory(String transaction) {
        history.add(transaction);
    }
}   