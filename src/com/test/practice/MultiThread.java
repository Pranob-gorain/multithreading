package com.test.practice;

public class MultiThread extends Thread{

	
	public void run() {
		System.out.println("Thread running using Thread extension");
	}
	public static void main(String[] args) {
		
		MultiThread t = new MultiThread();
		ThreadExample  t2 = new ThreadExample();
		
		//Runnable r = () -> System.out.println("Using runnable lambda");
		Thread t3 = new Thread(() -> System.out.println("Using runnable lambda"));	
		Thread t1 = new Thread(t2);
		t1.start();
		t.start();
		t3.start();
	}
	
	
}

class ThreadExample implements Runnable {

	@Override
	public void run() {
		
		System.out.println("Thread running using Runnable");
	}
	
}
