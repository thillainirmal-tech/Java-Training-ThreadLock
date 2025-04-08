package com.example.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class mysyncBankaccount1 {
    private double balance;
    private final Lock lock = new ReentrantLock();

    public mysyncBankaccount1(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ", New Balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " withdraw failed");
            }
        } finally {
            lock.unlock();
        }
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            if (amount > 0) {
                balance += amount;
                System.out.println(Thread.currentThread().getName() + " deposited " + amount + ", New Balance: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " deposit failed. Invalid amount.");
            }
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockExample { // <-- Renamed class here
    public static void main(String[] args) {
        mysyncBankaccount1 account = new mysyncBankaccount1(1000);

        Thread t1 = new Thread(() -> account.deposit(500), "Thread-Deposit");
        Thread t2 = new Thread(() -> account.withdraw(300), "Thread-Withdraw-1");
        Thread t3 = new Thread(() -> account.withdraw(800), "Thread-Withdraw-2");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
}
