package com.tj.core.concurrency;

public class KCounter {
	
	    private int c = 0;

	    public void increment() {
	        c++;
	    }

	    public void decrement() {
	        c--;
	    }

	    public int value() {
	        return c;
	    }

	
}
