package code.arrays;

/*
 * https://www.geeksforgeeks.org/count-pairs-array-whose-sum-less-x/
 * */
public class CountPairsLessThanX {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8};
		int r = 7;
		System.out.println(findPairs(a, r));
	}

	//arr is sorted array and we need to find pairs in sorted array less than x.
	static int findPairs(int[] arr, int x) {
		int l = 0, r = arr.length - 1;
		int result = 0;
		while (l < r) {
			//when adding arr[r] i able to get us < X then all elements upto r will be < X since arr is sorted.
			//so we increase our result with r-l elements each time this condition 
			//satisfies and move on to next pair with new 'l' else we decrease 'r' and try checking this condition.
			if (arr[l] + arr[r] < x) {
				result = result + r - l;
				l++;
			} else {
				r--;
			}
		}
		return result;
	}
}
