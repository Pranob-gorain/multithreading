package com.test.practice;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
		TestCyclicBarrier barrier = new TestCyclicBarrier(cyclicBarrier);
		Thread t1 = new Thread(barrier::test);
		Thread t2 = new Thread(barrier::test);
		Thread t3 = new Thread(barrier::test);
		t1.start();
		t2.start();
		t3.start();
		System.out.println("All done");
	}
}

class TestCyclicBarrier {
	CyclicBarrier barrier;
	public TestCyclicBarrier(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	public void test() {
		System.out.println("Thread name is "+Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
			barrier.await();
			System.out.println("DOne for thread "+Thread.currentThread().getName());
		} catch (InterruptedException | BrokenBarrierException e) {
			 System.out.println(barrier.getNumberWaiting());
			e.printStackTrace();
		}
	}
	
}