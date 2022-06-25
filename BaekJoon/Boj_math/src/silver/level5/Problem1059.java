package silver.level5;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1059 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int l = scan.nextInt(); // size of set S
		int[] s = new int[l]; // set S

		for (int i = 0; i < l; i++) {
			s[i] = scan.nextInt();
		}

		Arrays.sort(s); // sort

		int n = scan.nextInt(); // n

		int sIdx, eIdx; // start index, end index
		sIdx = 0;
		eIdx = 0;

		for (int i = 0; i < l; i++) {
			if (s[i] >= n) {
				sIdx = i - 1;
				eIdx = i;
				break;
			}
		}

		int leftC = sIdx == -1 ? n : n - s[sIdx];
		int rightC = s[eIdx] - n;

		System.out.println(leftC * rightC == 0 ? 0 : leftC * rightC - 1);
	}

}
