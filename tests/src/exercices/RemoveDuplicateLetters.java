package exercices;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicateLetters {
	/* Solution 1 */
	public static String removeDuplicateLetters(String str) {

		String ans = "";
		for (int i = 0; i < str.length(); i++) {
			int j = 0;
			for (j = 0; j < i; j++) {
				if (str.charAt(i) == str.charAt(j)) // same character found
				{
					break;
				}
			}
			if (i == j) {
				ans += str.charAt(i);
			}
		}
		return ans;
	}

	/* Solution 2 */
	public static String removeDuplicateLettersJava8(String str) {

		return Arrays.asList(str.split("")).stream().distinct().collect(Collectors.joining());
	}

	public static String SortingString(String str) {
		String strNoDuplicates = removeDuplicateLettersJava8(str);
		char charArray[] = strNoDuplicates.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	public static void main(String[] args) throws Exception {
		System.out.println(removeDuplicateLetters("cbacdcbc"));
		System.out.println(removeDuplicateLettersJava8("cbacdcbc"));

		System.out.println(SortingString("cbacdcbc"));
	}
}
