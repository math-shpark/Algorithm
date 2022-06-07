package silver.level5;

import java.util.Scanner;

public class Problem2740 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n, m;
		n = scan.nextInt(); // N
		m = scan.nextInt(); // M

		int[][] a = new int[n][m]; // A

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				a[r][c] = scan.nextInt();
			}
		} // A info

		m = scan.nextInt();
		int k = scan.nextInt(); // K

		int[][] b = new int[m][k]; // B

		for (int r = 0; r < m; r++) {
			for (int c = 0; c < k; c++) {
				b[r][c] = scan.nextInt();
			}
		} // B info

		int[][] result = new int[n][k]; // A * B

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < k; c++) {
				for (int i = 0; i < m; i++) {
					result[r][c] += a[r][i] * b[i][c];
				}
			}
		} // A * B operate

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < k; c++) {
				System.out.print(result[r][c] + " ");
			}
			System.out.println();
		} // print
	}

}
