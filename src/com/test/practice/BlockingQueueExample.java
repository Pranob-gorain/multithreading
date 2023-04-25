package com.test.practice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(1);
		QueueV queue = new QueueV(bq);
		Thread t1 = new Thread(() ->{
			try {
				queue.put();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				queue.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		t1.start();
		Thread.sleep(500);
		t2.start();
	}
}
	
	class QueueV{
		BlockingQueue<Integer> bq;
		public QueueV(BlockingQueue<Integer> bq) {
			this.bq = bq;
		}
		
		int num =0;
		public void put() throws InterruptedException {
			while(true) {
				System.out.println("PUT :"+num);
				bq.put(num++);
				Thread.sleep(1000);
			}
		}
		public void get() throws InterruptedException {
			while(true) {
				int num =bq.take();
				System.out.println("GET :"+num);
				Thread.sleep(1000);
			}
		}
}
