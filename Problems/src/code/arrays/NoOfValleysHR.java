package code.arrays;

public class NoOfValleysHR {

	public static void main(String[] args) {
		String b = "UDDDUDUU";
		int a = 8;
		System.out.println(countingValleys(a, b));
	}

	static int countingValleys(int n, String s) {
		int count = 0;
		int currentStepVal = 0;
		for (int i = 0; i < s.length(); i++) {
			if (String.valueOf(s.charAt(i)).equals("U")) {
				currentStepVal = currentStepVal + 1;
				if (currentStepVal == 0)
					count++;
			} else {
				currentStepVal = currentStepVal - 1;
			}
		}
		return count;
	}
}
