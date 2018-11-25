package code.arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int[] ar = {1,2,3,4,5,6,7};
		int[] res = reverseArray(ar);
		for(int i = 0;i<res.length;i++) {
			System.out.println(res[i]);
		}
	}
	
	public static int[] reverseArray(int[] a) {
		int temp;
		for(int i =0;i<a.length/2;i++) {
			temp = a[i];
			a[i] = a[a.length-1-i];
			a[a.length-1-i] = temp;
		}
		return a;
	}
	
}
