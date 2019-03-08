package com.tj.core;

public class Test {
	
	public static void main(String[] args) {
		
		Circle c = new Circle(2,4);
		moveCircle(c, 5, 3);
		System.out.println(c);
		
		for(int i = 0;i<10;i++)
		System.out.println(Math.random()*100);
	}
	
	static void moveCircle(Circle cir,int x,int y) {
		cir.setX(cir.getX()+x);
		cir.setY(cir.getY()+y);
		cir = new Circle();
		System.out.println(cir);
	}

	
}
