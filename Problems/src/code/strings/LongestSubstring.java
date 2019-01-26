package code.strings;

import java.util.Scanner;

public class LongestSubstring {

	public static void main(String[] args) {
	
		//Scanner reader = new Scanner(System.in);
		
		String a = "ABCDECDRG";
		String b = "CDRGTABCDE";
		System.out.println(longestSubstring(a, b));
	
	}
	
	
	private static int longestSubstring(String a,String b) {
		int[][] matrix = new int[a.length()+1][b.length()+1];
		int result=0;
		for(int i = 0;i<=a.length();i++) {
			for(int j = 0;j<=b.length();j++) {
				if(i==0||j==0) {
					matrix[i][j]=0;
				}
				else if(a.charAt(i-1)==b.charAt(j-1)) {
					matrix[i][j] = matrix[i-1][j-1]+1;
					result = Math.max(result, matrix[i][j]);
				}
				else {
					matrix[i][j]=0;
				}
			}
		}
		return result;
	}
}
