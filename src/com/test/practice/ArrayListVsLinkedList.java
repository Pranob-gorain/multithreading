package com.test.practice;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {
	
	public static void main(String[] args) {
		List<String> arrList = new ArrayList<>();
		List<String> lnkedList = new LinkedList<>();
		
		int max =5000000;
		int i=0;
		Instant start = Instant.now();
		while(i<=max) {
			arrList.add(i+"Test");
			i++;
		}
		Instant end = Instant.now();
		int totalTimeArrayListToAdd = end.getNano()-start.getNano();
		System.out.println(totalTimeArrayListToAdd);
		
		int j=0;
		Instant startJ = Instant.now();
		while(j<=max) {
			lnkedList.add(j+"Test");
			j++;
		}
		Instant endJ = Instant.now();
		int totalTimeLnkedListToAdd = endJ.getNano()-startJ.getNano();
		System.out.println(totalTimeLnkedListToAdd);
		
	}

}
