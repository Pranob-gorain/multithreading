package com.test.practice;

public class StaticSync {
	
	public static void main(String[] args) {
		StaticSyncTest staticSyncTest = new StaticSyncTest();
		StaticSyncTest staticSyncTest1 = new StaticSyncTest();
		Thread t1 = new Thread(() -> staticSyncTest.test1("1"));
		Thread t2 = new Thread(() -> staticSyncTest1.test1("2"));
		t1.start();
		t2.start();
	}
	
}
class StaticSyncTest {
	public synchronized static void test(String name) {
		for(int i=0;i<10;i++) {
			System.out.println("Thread name is "+name);
		}
	}
	
	public void test1(String name) {
		StaticSyncTest staticSyncTest = new StaticSyncTest();
		staticSyncTest.test(name);
	}
}
