package silver.level4;

import java.util.HashSet;
import java.util.Scanner;

public class Problem16922 {

	static int num;
	static int[] arr = { 1, 5, 10, 50 }; // possible number array
	static HashSet<Integer> set;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		num = scan.nextInt(); // the number of selection
		set = new HashSet<Integer>();

		for (int i = 0; i < 4; i++) {
			comb(arr[i], i, 1); // combination
		}

		System.out.println(set.size()); // print
	}

	private static void comb(int sum, int idx, int count) {
		if (count == num) {
			set.add(sum); // data input
			return;
		}

		for (int i = idx; i < 4; i++) {
			comb(sum + arr[i], i, count + 1); // stack
		}
	}

}
