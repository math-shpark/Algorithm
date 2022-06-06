package figure;

import java.util.Scanner;

public class Code1707 {

	static int[][] square;
	static int n;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		square = new int[n][n];

		if (n == 1) {
			System.out.println(1);
			return;
		}

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				square[r][c] = -1;
			}
		}

		right(0, 0, 1);

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				System.out.print(square[r][c]);
				if (c != n - 1)
					System.out.print(" ");
				else
					System.out.println();
			}
		}
	}

	private static void right(int r, int c, int num) {
		while (true) {
			square[r][c] = num;
			num++;
			c++;
			if (c >= n || square[r][c] != -1)
				break;
		}

		r++;
		c--;

		if (square[r][c] == -1)
			down(r, c, num);
	}

	private static void down(int r, int c, int num) {
		while (true) {
			square[r][c] = num;
			num++;
			r++;
			if (r >= n || square[r][c] != -1)
				break;
		}

		r--;
		c--;
		if (square[r][c] == -1)
			left(r, c, num);
	}

	private static void left(int r, int c, int num) {
		while (true) {
			square[r][c] = num;
			num++;
			c--;
			if (c < 0 || square[r][c] != -1)
				break;
		}

		r--;
		c++;

		if (square[r][c] == -1)
			up(r, c, num);

	}

	private static void up(int r, int c, int num) {
		while (true) {
			square[r][c] = num;
			num++;
			r--;
			if (square[r][c] != -1)
				break;
		}

		r++;
		c++;
		if (square[r][c] == -1)
			right(r, c, num);
	}

}
