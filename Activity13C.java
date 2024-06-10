import java.util.ArrayList;
import java.util.List;

public class Activity13C {
    public static void main(String[] args) throws InterruptedException {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new BankAccountThread(account1, true, 100));
            threads.add(new BankAccountThread(account2, true, 200));
            threads.add(new BankAccountThread(account1, false, 50));
            threads.add(new BankAccountThread(account2, false, 100));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Account 1 balance: " + account1.getBalance());
        System.out.println("Account 2 balance: " + account2.getBalance());
    }
}
class BankAccount {
    private int balance;
    public BankAccount(int balance) {
        this.balance = balance;
    }
        public int getBalance() {
        return balance;
    }
    public void deposit(int amount) {
    // TODO: synchronize access to this method
        balance += amount;
    }
    public void withdraw(int amount) {
    // TODO: synchronize access to this method
        balance -= amount;
    }
}
    class BankAccountThread extends Thread {
        private final BankAccount account;
        private final boolean isDeposit;
        private final int amount;
        public BankAccountThread(BankAccount account, boolean isDeposit, int amount) {
            this.account = account;
            this.isDeposit = isDeposit;
            this.amount = amount;
    }
    @Override
    public void run() {
        if(isDeposit) account.deposit(amount);
        else account.withdraw(amount);
    }
}