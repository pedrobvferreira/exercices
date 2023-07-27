package exercices;

import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveNumber {

	public int solution(int[] A) {
        // Implement your solution here
        int N = A.length;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= N + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return N;
    }
	
	public static void main(String[] args) throws Exception {
		
	}
			 
}
