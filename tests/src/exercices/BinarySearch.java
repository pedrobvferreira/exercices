package exercices;

public class BinarySearch {
	static int solution(int[] A, int X) {
        int N = A.length;
        if (N == 0) {
            return -1;
        }
        int l = 0;
        int r = N;
        while (l < r) {
            int m = (l + r) / 2;
            //System.out.print(l+" "+m+ " " + r+ " ");
            if (A[m] > X) {
                r = m - 1;
                System.out.println("r:"+r);
            } else {
                l = m;
                System.out.println("l:"+l);
            }
        }
        if (A[l] == X) {
            return l;
        }
        return -1;
    }
	
public static void main(String[] args) throws Exception {
		int[] A = {1,9,2,9,5};
		System.out.println(BinarySearch.solution(A, 5));
	}
}
