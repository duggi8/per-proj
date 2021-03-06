package code.sorting;

/*Divide and Conquer
 * Average complexity O(nlogn)
 * Quicksort is not adaptive - meaning it can't determine on beforehand if the list is already sorted and exit
 * call stack in recursion take space- O(logn) and iin worst case it is O(n)
 * NOT a stable sort
 * QuickSort is usually preferred over MergeSort*/
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {9,8,6,7,1,4,3,5,2};
		
		quickSort(arr, 0, arr.length-1);
		System.out.println("***final****");
		print(arr);
	}
	public static void quickSort(int[] listToSort,int low,int high) {
		if(low>=high)
			return;
		int pivotIndex = partition(listToSort,low,high);
		quickSort(listToSort, low, pivotIndex-1);
		quickSort(listToSort, pivotIndex+1, high);
	   
		
	}
	
	//I need to have a algorithm to shuffle < pivot and > pivot on either side
	/* compare pivot with next element if pivot is greater, swap them 
	 * else if element is greater push it to end of list and decrease the high pointer,
	 *  since you have already compared the last element and it was greater than pivot. */
	public static int partition(int[] list,int l ,int h) {
		int pivIndex = l;
		int pointer = l+1;
		int high = h;
		while(pointer <= high) {
			if(list[pivIndex] > list[pointer]) {
				swap(list,pivIndex,pointer);
				pivIndex = pointer;
				pointer++;
			}
			else  {
				swap(list,pointer,high);
				high--;
			}
			
		}
		System.out.println("final pivIndex after shuffle- " + pivIndex);
		print(list);
		System.out.println("**end**");
		return pivIndex;
	}
	public static void swap(int[] listSwap , int s1,int s2) {
		int temp = listSwap[s1];
		listSwap[s1] = listSwap[s2];
		listSwap[s2] = temp;
	}
	public static void print(int[] li) {
		for(int i = 0;i<li.length;i++) {
			System.out.println(li[i]);
		}
	}
}
