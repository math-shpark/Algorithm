package figure;

import java.util.Scanner;

public class Code1337 {

	static int[][] tri;
	static int n;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();

		tri = new int[n][n];

		int num = 0;

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				tri[r][c] = -1;
			}
		}

		diagonal(0, 0, num);

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (tri[r][c] != -1)
					System.out.print(tri[r][c] + " ");
				else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	}

	private static void diagonal(int row, int col, int num) {
		tri[row][col] = num;

		int newR = row + 1;
		int newC = col + 1;

		if (newR >= n || newC >= n || tri[newR][newC] != -1) {
			newR = row;
			newC = col - 1;

			if (tri[newR][newC] != -1)
				return;
			else {
				left(newR, newC, num + 1 == 10 ? 0 : num + 1);
			}
		} else {
			diagonal(newR, newC, num + 1 == 10 ? 0 : num + 1);
		}
	}

	private static void left(int row, int col, int num) {
		tri[row][col] = num;
		num++;
		if (num == 10)
			num = 0;

		int newR = row;
		int newC = col - 1;

		if (newC < 0 || tri[newR][newC] != -1) {
			newR = row - 1;
			newC = col;

			if (tri[newR][newC] != -1)
				return;
			else
				up(newR, newC, num);
		} else {
			left(newR, newC, num);
		}
	}

	private static void up(int row, int col, int num) {
		tri[row][col] = num;
		num++;
		if (num == 10)
			num = 0;

		int newR = row - 1;
		int newC = col;

		if (tri[newR][newC] != -1) {
			newR = row + 1;
			newC = col + 1;
			if (tri[newR][newC] != -1)
				return;
			else
				diagonal(newR, newC, num);
		} else {
			up(newR, newC, num);
		}
	}

}
