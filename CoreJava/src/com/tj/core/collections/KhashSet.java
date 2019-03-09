package com.tj.core.collections;

import java.util.HashSet;
import java.util.Set;

public class KhashSet {

	public static void main(String[] args) {
		
		Set<Integer> ints = new HashSet<>();
		for(int i=0; i<10; i++){
			ints.add(i);
		}
		System.out.println("ints set = "+ints);
		
		// set to array example
		Integer[] intArray = new Integer[ints.size()];
		intArray =ints.toArray(intArray);
	}
}
