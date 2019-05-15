package code.dynamicProgramming;

public class MaxSumSubSequenceNonAdjacent {

	public static void main(String[] args) {
		int[] ar = {3,7,4,6,5};
		System.out.println(maxSubsetSum(ar));
	}
    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
    	int incl = arr[0];
    	int excl = 0;
    	int temp=0;
    	for(int i =1;i<arr.length;i++) {
        
        //when you exclude current element
    	temp = Math.max(incl, excl);
    	
    	//when you include current element
    	incl = arr[i]+excl;
    	
    	//update exclude val from temp
    	excl = temp;
    		
    	}
    	
    	return Math.max(incl,excl);

    }
}
