package com.example.thread;

public class ThreadClass extends Thread{
		@Override
		public void run() {
			for(int i = 1;i<5;i++) {
				System.out.println("Thread: "+Thread.currentThread().getId()+"count"+i);
				
			}
		}
}
