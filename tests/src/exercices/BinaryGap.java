package exercices;

public class BinaryGap {
	public static int solution(int N) {
		// Implement your solution here
		int longestBinaryGap = 0;
		String binary = Integer.toBinaryString(N);
		if (!binary.contains("01")) {
			return 0;
		}

		binary = binary.replaceAll("0*$", "");
		String[] gaps = binary.split("1");

		for (String g : gaps) {
			if (g.length() > longestBinaryGap) {
				longestBinaryGap = g.length();
			}
		}

		return longestBinaryGap;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(solution(1041));
	}
}

