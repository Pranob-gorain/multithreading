package com.test.practice;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	
	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(2);
		TestSemaphore test = new TestSemaphore(semaphore);
		Thread t1 = new Thread(test::test);
		Thread t2 = new Thread(test::test);
		Thread t3 = new Thread(test::test);
		t1.start();
		t2.start();
		t3.start();
	}
}




class TestSemaphore {
	Semaphore semaphore;
	public TestSemaphore(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void test() {
		try {
			semaphore.acquire();
			System.out.println("Called by thread "+Thread.currentThread().getName());
			Thread.sleep(2000);
			semaphore.release();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}