package com.test.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

	
	
	public static void main(String[] args) throws InterruptedException {
		TestAtomic testAtomic = new TestAtomic();
		Thread t1 = new Thread(testAtomic::test);
	       
        // starting thread t1
        t1.start();
        Thread t2 = new Thread(testAtomic::test);
       
        // starting thread t2
        t2.start();
       
        // calling join method on thread t1
        t1.join();
       
        // calling join method on thread t1
        t2.join();
       
        // displaying the count
        System.out.println("count=" + testAtomic.getCount());
	}
}

class TestAtomic {
	
	private AtomicInteger count = new AtomicInteger();
	public void test() {
		for (int i = 1; i <= 5; i++) {
			 
			count.incrementAndGet();
        }
	}
	public int getCount() { 
		return count.get(); 
	}
}
