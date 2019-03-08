package code.arrays;

public class StockBuySellMaximize {

	public static void main(String[] args) {
		int[] prices = {100, 180, 260, 310, 40, 535, 695};
		System.out.println(maximizeProfitNaive(prices));
		System.out.println(maximizeProfit(prices));
		System.out.println(maximizeProfitOppositeSides(prices));
	}
	//O(n^2)
	static int maximizeProfitNaive(int[] arr){
		int profit = 0;
		for(int i=0;i<arr.length-1;i++) {
			for(int j = i+1;j<arr.length;j++) {
				profit= Math.max(profit, arr[j]-arr[i]);
			}
		}
		return profit;
	}
	//O(n)
	static int maximizeProfit(int[] arr) {
		int min_element=arr[0];
		int max_diff = arr[1]-arr[0];
		for(int i = 1;i<arr.length;i++) {
			if(arr[i]<min_element)
				min_element = arr[i];
			else
				max_diff = Math.max(max_diff,arr[i]-min_element);
		}
		return max_diff;
	}
	
	static int maximizeProfitOppositeSides(int[] arr) {
		int i=0,j=arr.length-1;
		int min_val=arr[0],max_val=arr[arr.length-1];
		while(i!=j) {
			min_val = Math.min(min_val, arr[i]);
			i++;
			max_val = Math.max(max_val, arr[j]);
			j--;
		}
		return max_val-min_val;
	}
}
