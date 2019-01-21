package dynamicProgramming;

public class Fibonacci {
	
	public static void main(String[] args) {
		for(int i =1;i<=10;i++) {
			System.out.println("i= " + i + " "+ fib(i));
		}
		
	}
	static int fib(int n) {
		if(n<=2)
			return 1;
		else
			return fib(n-1)+fib(n-2);
	}

}
