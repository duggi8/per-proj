package code.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*John works at a clothing store. He has a large pile of socks that he must pair by color for sale.
 * Given an array of integers representing the color of each sock, determine how many pairs of socks 
 * with matching colors there are.
For example, there are  socks with colors . There is one pair of color  and one of color . 
There are three odd socks left, one of each color. The number of pairs is .*/

/*sample input: 
9
10 20 20 10 10 30 50 10 20
sample output:
3*/
public class PairSocksHR {

	public static void main(String[] args) {

		int[] a = {10,20,20,10,10,30,50,10,20};
		System.out.println(sockMerchant(9, a));
		System.out.println(sockMerchant1(9, a));
	}

	public static int sockMerchant(int n, int[] ar) {
		int result = 0, temp = 0, tempCount = 0;
		Arrays.sort(ar);

		for (int i = 0; i < n; i++) {
			if (temp != ar[i]) {
				temp = ar[i];
				result = result + tempCount / 2;
				tempCount = 0;
				tempCount++;
			} else if (i == n - 1) {
				tempCount++;
				result = result + tempCount / 2;
			} else
				tempCount++;
		}
		return result;
	}
	
	public static int sockMerchant1(int n, int[] ar) {
		Map<Integer,Integer> map = new HashMap<>();
		Object[] boxed = IntStream.of(ar).boxed().toArray();
		Stream<Object> s = Stream.of(boxed);
		s.forEach(p->{
			if(map.containsKey(p)) {
				int val = map.get(p);
				val++;
				map.put((Integer) p, val);
			}
			else {
				map.put((Integer) p, 1);
			}
		});
		
		return map.values().stream().mapToInt(Integer::new).map(p->p/2).sum();
	}
}
