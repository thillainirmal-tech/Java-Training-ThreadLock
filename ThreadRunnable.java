package com.example.thread;

public class ThreadRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =1;i<5;i++) {
			System.out.println("Thread: "+Thread.currentThread().getId()+"count: "+i);
		}
	}

	
}
