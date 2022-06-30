package silver.level3;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1183 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt(); // N

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt() - scan.nextInt();
		}

		Arrays.sort(arr);

		if (n % 2 == 1)
			System.out.println(1);
		else
			System.out.println(arr[n / 2] - arr[n / 2 - 1] + 1);
		
		scan.close();
	}
}