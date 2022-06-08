package figure;

import java.util.Scanner;

public class Code2074 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt(); // n

		int[][] map = new int[n][n];

		int r = 0;
		int c = n / 2;

		for (int num = 1; num <= n * n; num++) {
			map[r][c] = num;

			if (num % n == 0) {
				r += 1;
			} else {
				r -= 1;
				c -= 1;

				if (r < 0)
					r = n - 1;
				if (c < 0)
					c = n - 1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]);
				if (j != n - 1)
					System.out.print(" ");
				else
					System.out.println();
			}
		}
	}

}
