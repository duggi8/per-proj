package code.arrays;
//How do you find the missing number in a given integer array of 1 to 100?
//How do you find multiple missing number in a given integer array of 1 to 100?

public class MissingNumber {

	public static void main(String[] args) {
		int[] a = {1,2,3,5,6,7,8};
		System.out.println(getMissingNumber(a, 8));
		
		int[] b = {1, 2, 3, 4, 9, 8};
		getMultipleMissingNumber(b, 10);
	}

	private static int getMissingNumber(int[] numbers, int totalCount) {
		int expectedSum = totalCount * (totalCount + 1) / 2;
		int actualSum = 0;
		for (int i : numbers) {
			actualSum += i;
		}
		return expectedSum - actualSum;
	}

	//new int[]{1, 2, 3, 4, 9, 8}, 10

	private static void getMultipleMissingNumber(int[] numbers, int totalCount) {
		int[] arr = new int[totalCount];
		int temp=0;
		for(int i = 0;i< numbers.length;i++) {
			temp = numbers[i];
			arr[temp-1] = temp;
		}
		for(int i = 0;i<arr.length;i++) {
			if(arr[i]==0)
				System.out.println("missing number-" + (i+1));
		}
	}
}
