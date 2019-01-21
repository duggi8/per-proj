package dynamicProgramming;

public class MinCoinForSum {

	public static void main(String[] args) {
		/*int[] coins = new int[4];
		coins[0] = 9;
		coins[1] = 6;
		coins[2] = 5;
		coins[3] = 1;
		int sum = 11;
		int[] minCoins = calculateMinCoinsForSum(coins, sum);
		for (int i = 0; i < minCoins.length; i++) {
			System.out.println("Sum = "+ i + " Min coins = " +minCoins[i]);
		}*/
		
		long[] coin = new long[4];
		coin[0] = 2;
		coin[1] = 3;
		coin[2] = 5;
		coin[3] = 6;
		long s = 10;
		
		System.out.println(getWays(s,coin));
	}
	
	/*Problem - To find minimum number of coins from set of coins to sum and make value 'S'
	 * Algorithm-
	 * create array with length sum+1 to store minimum coins for each sum value from 0 to sum.
	 * loop for each sum from i =0 to i = sum
	 * loop for each coin value
	 * check if coin value is less or equal to current sum val
	 * if yes
	 * find diff and get min coins already calculated for difference and then add +1
	 * 
	 * */

	private static int[] calculateMinCoinsForSum(int[] coins, int sum) {

		int[] minSum = new int[sum + 1];
		minSum[0] = 0;
		int minCoins = 0;

		for (int i = 1; i < minSum.length; i++) {
			minSum[i] = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
	
				if (coins[j] <= i) {

					int diff = i - coins[j];
					minCoins = minSum[diff] + 1;
					minSum[i] = Math.min(minCoins, minSum[i]);
				}

			}
		}
		return minSum;
	}

	/* Problem - We have to find number of ways to make 'n' using coins in array.
	 * Find sub problems who can be added to get result of bigger problem.
	 * 
	 * for example- coins-> 1,2,3 Sum = 5
	 * 
	 * no of ways(now) to make '5' can be written as ->now(5) 
	 * now(5) using {1,2,3} = now(5) using {1,2} ----------> (1)
	 *                      + now(2) using {1,2,3}---------> (2)
	 * 
	 * The (2) is written keeping in mind that for every way (2) has, we are going to add
	 * '3' to it. So finally it will be writing 5 using all possible ways from using ONLY 1,2
	 * and 1,2,3 using 3 in every way. To use '3' in every way we need 5-3 to be sum.
	 * So we need now(2) using {1,2,3}
	 *
	 *                                            
	 * 
	 *    0   1    2   3    4     5
	 * 0  
	 * 1
	 * 2
	 * 3
	 * 
	 * */
	static long getWays(long n, long[] c) { 

		long[] waysArr = new long[(int) n + 1];
		waysArr[0] = 1;
		for (int i = 0; i < c.length; i++) {
			for (long j = c[i]; j <= n; j++) {
				waysArr[(int) j] = waysArr[(int) j] + waysArr[(int) (j - c[i])];
			}
		}

		return waysArr[(int) n];
	}
	
}
