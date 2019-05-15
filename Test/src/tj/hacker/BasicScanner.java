package tj.hacker;

import java.util.Scanner;

public class BasicScanner {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		int b = scan.nextInt();
		System.out.println(a + b);
		scan.nextDouble();
		
		scan.close();
	}
}

