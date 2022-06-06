package figure;

import java.util.Scanner;

public class Code1641 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int m = scan.nextInt();

		if (n < 0 || n > 100 || n % 2 == 0 || m < 1 || m > 3) {
			System.out.println("INPUT ERROR!");
			return;
		}

		int[][] tri = new int[n][n + (n - 1)];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < 2 * n - 1; c++) {
				tri[r][c] = -1;
			}
		}

		switch (m) {
		case 1:
			int num = 1;
			int max = 1;
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < max; c++) {
					tri[r][c] = num;
					if (c != max - 1) {
						if (r % 2 == 0) {
							num++;
						} else {
							num--;
						}
					}
				}
				max++;
				if (r % 2 == 0)
					num = tri[r][max - 2] + max;
				else
					num = tri[r][0] + 1;
			}
			break;
		case 2:
			int startCol = 0;
			int count = n + (n - 1);

			for (int r = 0; r < n; r++) {
				for (int c = startCol; c < startCol + count; c++) {
					tri[r][c] = r;
				}
				startCol++;
				count -= 2;
			}
			break;
		case 3:
			int range = 1;
			int add = 1;
			int startC = 0;
			for (int r = 0; r < n; r++) {
				for (int c = startC, idx = 1; c < startC + range; c++) {
					tri[r][c] = idx;
					idx++;
				}
				range += add;
				if (range == n / 2 + 1)
					add = -1;
			}
			break;
		}

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < tri[0].length; c++) {
				if (tri[r][c] == -1)
					System.out.print("  ");
				else
					System.out.print(tri[r][c] + " ");
			}
			System.out.println();
		}
	}

}
