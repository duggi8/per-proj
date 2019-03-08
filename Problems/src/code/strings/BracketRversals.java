package code.strings;

import java.util.Stack;

public class BracketRversals {

	public static void main(String[] args) {

		/*String s = "{}";
		char c = s.charAt(0);
		char c1 = s.charAt(1);
		System.out.println((int) c);
		System.out.println((int) c1);*/
		String str = "}{{}}{{{";
		System.out.println(countMinReversals(str));

		// type conversion. 5/2 results in int as both 5 and 2 are integers.
		/*double a = (double) 5 / 2;
		System.out.println(a);
		System.out.println((int) Math.ceil(a));*/
	}

	/*
	 * -> }{{}} {{{ The idea is to ignore the already balanced brackets and the
	 * remaining brackets are paired and evaluated for the min number of reversals.
	 * For example 
	 * }{ - this requires 2 reversals
	 * {{ - this requires 1 reversal 
	 * }} - this requires 1 reversal
	 * {} - this requires 0 reversal
	 * hence for }{{{--> }{ + {{ = 2+1 = 3 min reversals.  
	 */
	static int countMinReversals(String s) {
		Stack<Character> st = new Stack<>();
		int m = 0, n = 0;
		if (s.length() % 2 != 0)
			return -1;
		else {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '{') {
					st.push(s.charAt(i));
				} else if (s.charAt(i) == '}') {
					if (st.isEmpty()) {
						st.push(s.charAt(i));

					} else {
						if (st.peek().equals('{'))
							st.pop();
					}
				}
			}
			if (st.isEmpty())
				return 0;
			else {
				while (!st.isEmpty()) {
					if (st.pop().equals('{'))
						m++;
					else
						n++;
				}
			}

		}
		return (int) (Math.ceil((double)m/2) + Math.ceil((double)n/2));
	}
}
