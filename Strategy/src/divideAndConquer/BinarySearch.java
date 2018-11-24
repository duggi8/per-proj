package divideAndConquer;

public class BinarySearch {

	public static void main(String[] args) {
		int[] ar = {34,2,6,12,17,23};
		
		System.out.println(binarySearch(ar, 12, 0, 5));
	}
	//recursive implementation
	public static int binarySearch(int[] a, int t,int l, int h) {
		if(l>h)
			return -1;
		int mid = (l+h)/2;
		if(a[mid]==t)
			return mid;
		else if(t< a[mid]) {
			return binarySearch(a, t, l, mid-1);
		}
		else {
			return binarySearch(a, t, mid+1, h);
		}
		
	}
}
