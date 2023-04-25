package com.test.practice;

public class OddEvenThreads {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		OddEven oddEVen = new OddEven();
		Thread t1 = new Thread(oddEVen::test);
		t1.setName("Thread t1");
		Thread t2 = new Thread(() -> oddEVen.test());
		t2.setName("Thread t2");
		
		t1.start();
		t2.start();
	}
}

class OddEven {
	public  void test() {
		
		for(int i=1; i<=100;i++) {
			String name = Thread.currentThread().getName();
			if(name.equalsIgnoreCase("Thread t1") && i%2==0) {
				System.out.println("Number is "+i+" Thread is "+Thread.currentThread().getName());
			}
			if(name.equalsIgnoreCase("Thread t2") && i%2!=0) {
				System.out.println("Number is "+i+" Thread is "+Thread.currentThread().getName());
			}
		}
		
		
	}
}