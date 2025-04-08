package com.example.thread;

public class ThreadExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//threadclass
		ThreadClass thread1 = new ThreadClass();
		ThreadClass thread2 = new ThreadClass();
		
		//start thread
		thread1.start();
		thread2.start();

	}

}
