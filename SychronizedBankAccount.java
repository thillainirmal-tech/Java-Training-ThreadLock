package com.example.thread;

class mysyncBankaccount {
    private double balance;

    public mysyncBankaccount(double intialbalance) {
        this.balance = intialbalance;
    }

    // synchronized withdraw
    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", New Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " withdraw failed");
        }
    }

    // synchronized deposit
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", New Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " deposit failed. Invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class SychronizedBankAccount {
    public static void main(String[] args) {
        mysyncBankaccount account = new mysyncBankaccount(1000);

        // Create a deposit thread
        Thread depositThread = new Thread(() -> {
            account.deposit(500);
        }, "DepositThread");

        // Create a withdraw thread
        Thread withdrawThread = new Thread(() -> {
            account.withdraw(300);
        }, "WithdrawThread");

        // Create another withdraw thread to simulate conflict
        Thread anotherWithdraw = new Thread(() -> {
            account.withdraw(800);
        }, "WithdrawThread2");

        // Start all threads
        depositThread.start();
        withdrawThread.start();
        anotherWithdraw.start();

        try {
            depositThread.join();
            withdrawThread.join();
            anotherWithdraw.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}

