package com.linkedListImp;

public class QueueUnderflowException extends Exception {
	public QueueUnderflowException(String msg) {
		System.out.println(msg);
	}
}
