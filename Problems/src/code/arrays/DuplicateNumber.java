package code.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// how to find duplicate number in array?
//find solution without using java collection api.
public class DuplicateNumber {

	public static void main(String[] args) {
		int[] n = {1,2,3,6,6,7,7,1};
		toPrintDuplicates(n);
	}
	
	public static void toPrintDuplicates(int[] numbers) {
		Set<Integer> s = new HashSet<>();
		for(int i =0;i< numbers.length;i++) {
			if(s.add(numbers[i])) {
				System.out.println("added- " + numbers[i]);
			}
			else
				System.out.println("duplicate- " + numbers[i]);
		}
	}
	
	public static boolean toCheckIfDupsExist(int[] numbers) {
		List list = Arrays.asList(numbers);
		Set set = new HashSet<>(list);
		if(set.size()<list.size()) {
			return true;
		}
		else
			return false;
	}
	
	
}
