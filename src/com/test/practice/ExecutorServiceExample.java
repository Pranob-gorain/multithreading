package com.test.practice;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceExample {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Test test = new Test();
		CompletableFuture<String> cf = new CompletableFuture<>();
		//CompletableFuture.supplyAsync(null);
		Optional<String> op = Optional.ofNullable("Hello");
		Future<String> future = null;
		int i=0;
		ExecutorService ex = Executors.newFixedThreadPool(1);
		Executors.newSingleThreadExecutor();
		//ex.execute(test::test); //Doesn't return any value
		while(i<10) {
		future = ex.submit(test::test); //Returns value
			//CompletableFuture<String> v = CompletableFuture.supplyAsync( test::test);
			//System.out.println(v.get()); ;
		i++;
		}
		while(!future.isDone()) {
			System.out.println("Waiting for future");
		}
		System.out.println(future.get());
		ex.shutdown();
		//ex.submit(null)
	}

}

class Test {
	public String test() {
		AtomicInteger ai = new AtomicInteger(1);
		int i =1;
	System.out.println(Thread.currentThread().getName());	;
	ai.getAndIncrement();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Testing bhai "+ai.get();
	}
}
