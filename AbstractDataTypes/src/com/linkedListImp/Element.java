package com.linkedListImp;

public class Element<T> {

	public T data;
	public Element<T> next;

	public Element(T data, Element<T> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public Element(T data) {
		super();
		this.data = data;

	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Element<T> getNext() {
		return next;
	}

	public void setNext(Element<T> next) {
		this.next = next;
	}

}
