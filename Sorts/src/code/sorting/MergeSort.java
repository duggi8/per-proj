package code.sorting;

/*Merge sort uses recursion as tool The idea is to break the list until the length is 1 so that we can say it is 
 * sorted since there is only one element. Then we merge adjacent lists 
 * 
 * the main methods are 1. split (for splitting list into 2 parts)
 * 						2. merge (merge two lists to get a sorted list)
 * 						3. mergeSort (This is main method which uses split and merge to get final sorted list)
 * 
 * O(nlogn) is complexity
 * Is NOT adaptive- meaning it can't determine on beforehand if the lsit is already sorted and exit
 * O(n) extra space as we create smaller lists in recursive calls or divide phase
 * stable sort - two equal elements maintain the order once sort is complete.*/


public class MergeSort {

	public static void main(String[] args) {
    //{4,8,10,1,5,3,7,9}
		int[] a = {4,1};
		
		mergeSort(a);
	}

	public static void mergeSort(int[] listToSort) {
		if(listToSort.length==1)
			return;
		int midPoint = 0;
		midPoint = listToSort.length/2 + listToSort.length%2;
		int[] firstHalf = new int[midPoint];
		int[] secondHalf = new int[listToSort.length-midPoint];
		split(listToSort, firstHalf, secondHalf);
		mergeSort(firstHalf);
		mergeSort(secondHalf);
		merge(listToSort,firstHalf,secondHalf);
	}
	public static void split(int[] org, int[] osp1, int[] osp2) {
		int index = 0;
		for(int i = 0;i<osp1.length;i++) {
			osp1[i] = org[index];
			index++;
		}
		for(int j = 0;j<osp2.length;j++) {
			osp2[j] = org[index];
			index++;
		}
		
		print(osp1);
		print(osp2);
	}
	
	public static void print(int[] p) {
		for(int i = 0;i<p.length;i++) {
			System.out.println(p[i]);		
		}
		System.out.println("*************");
	}
	
	public static void merge(int[] org,int[] osp1,int[] osp2) {
		
		int posp1=0;
		int posp2=0;
		int index = 0;
		while(posp1<osp1.length && posp2<osp2.length) {
			if(osp1[posp1] <= osp2[posp2]) {
				org[index] = osp1[posp1];
				posp1++;
				index++;
			}
			else {
				org[index] = osp2[posp2];
				posp2++;
				index++;
			}
		}
		
		while(posp1<osp1.length) {
			org[index] = osp1[posp1];
			posp1++;
			index++;
		}
		while(posp2<osp2.length) {
			org[index] = osp2[posp2];
			posp2++;
			index++;
		}
		
		System.out.println("merged");
		print(org);
	}
	
}







