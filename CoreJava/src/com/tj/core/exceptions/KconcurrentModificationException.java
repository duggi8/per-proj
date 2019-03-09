package com.tj.core.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KconcurrentModificationException {

	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();

		myList.add("1");
		myList.add("2");
		myList.add("3");
		myList.add("4");
		myList.add("5");

		Iterator<String> it = myList.iterator();
		while (it.hasNext()) {
			
			String value = it.next();
			
			if (value.equals("5")) {
				//myList.set(2, "10"); //can update but iterator output is not same as actual list.
				//myList.add("11"); //java.util.ConcurrentModificationException
				//myList.remove("5");//java.util.ConcurrentModificationException
				/*myList.remove(4); //if you combine remove and add operations it will work because modCount remains same.
				myList.add("6");*/
			
			}
			    System.out.println("List Value:" + value);
			    
		}
		Iterator<String> it2 = myList.iterator();
	    while(it2.hasNext()) {
	    	System.out.println(it2.next());
	    }
		
		Map<String, String> myMap = new HashMap<String, String>();
		myMap.put("1", "1");
		myMap.put("2", "2");
		myMap.put("3", "3");

		Iterator<String> it1 = myMap.keySet().iterator();
		while (it1.hasNext()) {
			String key = it1.next();
			System.out.println("Map Value:" + myMap.get(key));
			if (key.equals("2")) {
				myMap.put("1", "4");
				// myMap.put("4", "4");
			}
		}

	}
}
