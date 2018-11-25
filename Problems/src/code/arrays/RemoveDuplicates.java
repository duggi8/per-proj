package code.arrays;

import java.util.Arrays;

//remove duplicates in array without using java collections api
public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 2, 3, 4, 5};
		int[] res = removeDups(arr);
		for(int i = 0;i<res.length;i++) {
			System.out.println(res[i]);
		}
	}
	
	public static int[] removeDups(int[] a) {
		int[] res = new int[a.length];
		int prev;
		Arrays.sort(a);
		res[0] = a[0];
		prev = a[0];
		
		for(int i = 1;i<a.length;i++) {
			if(a[i]!= prev) {
				res[i] = a[i];
				prev = res[i];
			}
			/*else {
			In this block you can count no of duplicates and then create an array of size without duplicates and then copy elements	
			}*/
		}
		return res;
	}

}
