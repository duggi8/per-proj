package com.tj.core.classLoading;

public class KLoading {

	 static final String a = "static final field";
	 
	 static String d = "static field";
	 
	 final String b =  "instance final field";
	 
	 String c = "instance field";
	 
	 static {
		
		 System.out.println("static block");
	 }
	
	 {
		 System.out.println("instance initializer block 1");
	 }
	 
	 public KLoading() {

	 System.out.println("inside KLoading constructor");
		 
	 }
	 
	 public KLoading(String s){
		 this.c = s;
	 }
	 
	 {
		 System.out.println("instance initializer block 2");
	 }
	 
	 static {
		 new KLoading();
		 System.out.println("static block 2" );
	 }
}
