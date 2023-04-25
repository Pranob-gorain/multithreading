package com.test.practice;

public class ProducerConsumer {
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		
		Thread t1 = new Thread(() -> {
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
		t2.start();
	}
	
}

class Queue {
	int num;
	boolean isValueSetAlready = false;
	public void put() throws InterruptedException {
		
		while(true) {
			synchronized (this) {
			if(isValueSetAlready) {
				wait();
			} 
				System.out.println("PUT : "+num);
				Thread.sleep(1500);
				isValueSetAlready = true;
				num++;
				notify();
			}
		}
	}
	
	public void get() throws InterruptedException {
		while(true) {
		 synchronized (this) {
		   if(isValueSetAlready) {
			 System.out.println("GET : "+num);
			 Thread.sleep(1500);
			 isValueSetAlready= false;
			 notify();
			 
		  } else {
			wait();
		    }
		
		}}
	}
}
