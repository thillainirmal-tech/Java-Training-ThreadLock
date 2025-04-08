package com.example.thread;

public class RunnableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadRunnable runobj = new ThreadRunnable();
		Thread thread3 = new Thread(runobj);
		Thread thread4 = new Thread(runobj);
		//start
		thread3.start();
		thread4.start();

	}

}
