package code.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*find all pairs of an integer array whose sum is equal to a given number*/
public class PairSum {

	public static void main(String[] args) {
		int[] n = { 14, 3, 8, 2, 9, 6, 1 };
		printPairs(n, 11);
		System.out.println("*******");
		printPairsUsingSet(n,11);
		inPlaceSol(n, 11);
	}
	//----> O(n^2) complexity , brute force solution
	public static void printPairs(int[] array, int sum) {
		for (int i = 0; i < array.length; i++) {
			int first = array[i];
			for (int j = i + 1; j < array.length; j++) {
				int second = array[j];
				if ((first + second) == sum) {
					System.out.printf("(%d, %d) %n", first, second);
				}
			}
		}
	}

	//add() and contains() both O(1) operation in hash table(HashSet here)  --> O(n) complexity
	public static void printPairsUsingSet(int[] numbers, int n) {
		if (numbers.length < 2) {
			return;
		}
		Set set = new HashSet(numbers.length);
		for (int value : numbers) {
			int target = n - value; // if target number is not in set then add
			if (!set.contains(target)) {
				set.add(value);
			} else {
				System.out.printf("(%d, %d) %n", value, target);
			}
		}
	}
	//--> O(nlogn) complexity because of sorting the given array.
	public static void inPlaceSol(int[] numbers,int n) {
		 Arrays.sort(numbers);
		 int leftPointer = 0;
		 int rightPointer = numbers.length-1;
		 while(leftPointer <= rightPointer) {
			 if(numbers[leftPointer]+numbers[rightPointer] >n) {
				 rightPointer--;
			 }
			 else if(numbers[leftPointer]+numbers[rightPointer] < n) {
				 leftPointer++;
			 }
			 else {
				 System.out.println("("+numbers[leftPointer]+","+numbers[rightPointer]+")");
				 leftPointer++;
				 rightPointer--;
			 }
				
		 }
	}
		
	
}


