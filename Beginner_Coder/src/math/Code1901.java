package math;

import java.util.Arrays;
import java.util.Scanner;

public class Code1901 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt(); // n

		for (int i = 0; i < n; i++) {
			int num = scan.nextInt();

			boolean[] arr = new boolean[2 * num + 1];

			Arrays.fill(arr, true);

			for (int j = 2; j <= Math.sqrt(2 * num); j++) {
				int multi = 1;

				while (j * multi <= 2 * num) {
					arr[j * multi] = false;
					multi++;
				}
			}

			for (int j = 0; j < num; j++) {
				boolean isFind = false;

				if (arr[num - j]) {
					isFind = true;
					System.out.print(num - j);
				}

				if (j != 0) {
					if (arr[num + j]) {
						if (isFind)
							System.out.print(" ");

						isFind = true;
						System.out.print(num + j);
					}

				}

				if (isFind) {
					System.out.println();
					break;
				}
			}
		}
	}

}
