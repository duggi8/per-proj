package com.tj.core.functions;

public class KCreateClone implements Cloneable {

	int a;
	int b;
	
	public KCreateClone(int a,int b) {
		this.a = a;
		this.b = b;
	}
	
	KCreateClone createClone() {
		try {
			return (KCreateClone)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return this;
		}
	}
}
