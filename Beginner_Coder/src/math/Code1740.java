package math;

import java.util.Scanner;

public class Code1740 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int m = scan.nextInt(); // M
		int n = scan.nextInt(); // N

		boolean[] arr = new boolean[n + 1];

		arr[0] = true;
		arr[1] = true;

		boolean isExist = false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			int multi = 2;

			while (i * multi <= n) {
				arr[i * multi] = true; // composite
				multi++;
			}
		}

		int sum = 0;
		int minVal = n;
		for (int i = m; i <= n; i++) {
			if (!arr[i]) {
				isExist = true;
				sum += i;
				if (minVal == n && i < n)
					minVal = i;
			}
		}

		if (isExist) {
			System.out.println(sum);
			System.out.println(minVal);
		} else
			System.out.println(-1);
	}

}
