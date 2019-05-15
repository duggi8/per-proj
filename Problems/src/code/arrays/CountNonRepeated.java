package code.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*ASHLEY LOVES NUMBERS
Given a range, print all numbers having unique digits.
Input is two dimensional list -> list inside a list. */
/*
Input : 10 20
Output : 10 12 13 14 15 16 17 18 19 20  (Except 11)

Input : 1 10
Output : 1 2 3 4 5 6 7 8 9 10*/
public class CountNonRepeated {

	public static void main(String[] args) {

		List<Integer> t1 = new ArrayList<>();
		List<Integer> t2 = new ArrayList<>();
		List<Integer> t3 = new ArrayList<>();
		t1.add(110);
		t1.add(125);
		List<List<Integer>> inputList = new ArrayList<>();
		inputList.add(t1);
		countNumbers(inputList);

	}

	// Complete the countNumbers function below.
	static void countNumbers(List<List<Integer>> arr) {

		for (int i = 0; i < arr.size(); i++) {
			int count = 0;
			List<Integer> li = arr.get(i);
			for (int j = li.get(0); j <= li.get(1); j++) {
				if (check(String.valueOf(j))) {
					count++;
				}

			}
			System.out.println(count);
		}

	}

	private static boolean check(String str) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			if (!set.contains(str.charAt(i))) {
				set.add(str.charAt(i));
			} else {
				return false;
			}
		}
		return true;
	}

}
