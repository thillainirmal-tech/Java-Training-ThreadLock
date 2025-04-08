package com.example.thread;

public class BankAccountApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account = new BankAccount();
		//multiple threads
		Thread withdrawThread = new Thread(()->{
			account.withdraw(10000.00);
		});
		Thread depositThread = new Thread(()->{
			account.deposit(1500.00);
		});
		Thread balanceThread = new Thread(()->{
			double balance = account.getBalance();
			System.out.println("current balance"+balance);
		});
		//start
		withdrawThread.start();
		depositThread.start();
		balanceThread.start();
		

	}

}
