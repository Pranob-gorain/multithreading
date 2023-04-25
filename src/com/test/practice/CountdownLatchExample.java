package com.test.practice;

import java.util.concurrent.CountDownLatch;

public class CountdownLatchExample {
	
	
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(3);
		ExampleCountdownLatch exampleCountdownLatch = new ExampleCountdownLatch(countDownLatch);
		Thread t1 = new Thread(exampleCountdownLatch::test);
		Thread t2 = new Thread(exampleCountdownLatch::test);
		Thread t3 = new Thread(exampleCountdownLatch::test);
		Thread t4 = new Thread(() -> exampleCountdownLatch.test1(0));
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		countDownLatch.await();
		System.out.println("ALl thread completed now");
	}
}

class ExampleCountdownLatch {
	CountDownLatch countDownLatch;
	public ExampleCountdownLatch(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}
	public void test() {
		System.out.println("Thread is "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		countDownLatch.countDown();
	}
	
	public void test1(int i) {
		System.out.println("Thread is "+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		countDownLatch.countDown();
	}
}
