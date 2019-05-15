package code.arrays;

import java.util.HashMap;
import java.util.Map;

public class RepeatedStringHR {

	public static void main(String[] args) {

		String input = "aba";
		long inp = 10;
		System.out.println(repeatedString(input, inp));
	}

	static long repeatedString(String s, long n) {

		int aUntilEachLetters = 0;

		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, aUntilEachLetters);
		
		for (int i = 0; i < s.length(); i++) {

			if (String.valueOf(s.charAt(i)).equals("a")) {
				aUntilEachLetters = aUntilEachLetters+1;
				map.put(i + 1, aUntilEachLetters);
			} else
				map.put(i + 1, aUntilEachLetters);
		}

		long repeats = n / s.length();
		int rem = (int) (n % s.length());
		/*	System.out.println(repeats);
			System.out.println(rem);
			System.out.println(map.get(s.length())*repeats);
			System.out.println(map.get(rem));*/
		return map.get(s.length()) * repeats  + map.get(rem);
	}

}
