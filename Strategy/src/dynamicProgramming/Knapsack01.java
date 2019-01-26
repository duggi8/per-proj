package dynamicProgramming;

/*Problem - Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights associated with n items 
respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that
sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or
don’t pick it (0-1 property).*/
public class Knapsack01 {

	public static void main(String[] args) {
		int[] w = {10,20,30};
		int[] v = {60,100,120};
		int C = 50;
		
		System.out.println("Max value in knapsack= " + weightsPicked(w, v, C));
		System.out.println("Max value in knapsack recursive = " + knapsack(C, w, v, w.length));
		System.out.println("Max value in knapsack space optimized= " + maxWeight(w, v, C));
	}

	static int weightsPicked(int[] w, int[] v, int C) {
		int[][] matrix = new int[w.length+1][C+1];
		
		for(int i = 0;i <=w.length; i++) {
			for(int j = 0;j<=C;j++) {
			
				if(i==0||j==0) {
					matrix[i][j]=0;
				}
				else if(w[i-1]>j) {
					matrix[i][j] = matrix[i-1][j];					
				}
				else  {
					/* 2 cases
					 * case A -without new weight what is the max value
					 * case B - include new weight, find remaining capacity after including this new weight and find out what is the max value
					 * you can include for remaining weight.*/
				int remainingCapacity = j -w[i-1];	
				matrix[i][j] = Math.max(matrix[i-1][j], matrix[i-1][remainingCapacity]+ v[i-1]);
				}
			}
		}
		
		return matrix[w.length][C];
	}
	
	//recursive impl
	static int knapsack(int W,int wt[],int[] val,int n) {
		if(n==0||W==0) {
		return 0;	
		}
		if(wt[n-1]>W) {
			return knapsack(W, wt, val, n-1);
		}
		else
			return Math.max(knapsack(W, wt, val, n-1), val[n-1]+ knapsack(W-wt[n-1], wt, val, n-1));
	}
	
	//space optimized
	static int  maxWeight(int[] w, int[] v, int C) {
		int[] maxWeightRow = new int[C+1];
		int count=0;
		for(int i = 0;i<w.length;i++) {
		 for(int j = C;j>=w[i];j--) {
				 maxWeightRow[j] = Math.max(maxWeightRow[j], maxWeightRow[j-w[i]]+v[i]);
		 }
		}
		return maxWeightRow[C];
	}
}
