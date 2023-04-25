package com.test.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEvenThreadsAnotherExample {
	
	public static void main(String[] args) throws InterruptedException {
		OddEvenTest oddEven = new OddEvenTest();
		Thread odd = new Thread(() -> {
			try {
				oddEven.testOdd();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		});
		Thread even = new Thread(() -> {
			try {
				oddEven.testEven();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		odd.setName("Odd");
		even.setName("Even");
		odd.start();
		even.start();
	}

}

class OddEvenTest {
	 int num=0;
	int maxNum =10;
	Lock lock = new ReentrantLock();
	Condition c = lock.newCondition();
	
	public  void testEven() throws InterruptedException {
		lock.lock();
		while(num <maxNum) {
			if(num%2!=0) {
				c.await();
			}
			if(num<maxNum) {
				System.out.println("Number is "+num+" by thread "+Thread.currentThread().getName());
				num++;
				c.signal();
			}
		}
		lock.unlock();
	}

	public  void testOdd() throws InterruptedException {
		lock.lock();
		while(num <maxNum) {
			if(num%2==0) {
				c.await();
			}
			if(num<maxNum) {
				System.out.println("Number is "+num+" by thread "+Thread.currentThread().getName());
				num++;
				c.signal();
			}
	    }
		lock.unlock();
	}
}
