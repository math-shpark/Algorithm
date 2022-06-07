package figure;

import java.util.Scanner;

public class Code1331 {

	static char[][] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		map = new char[2 * n - 1][2 * n - 1];

		for (int i = 0; i < 2 * n - 1; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				map[i][j] = '0';
			}
		}

		char letter = 'A';

		ld(0, n - 1, letter);

		for (int r = 0; r < 2 * n - 1; r++) {
			for (int c = 0; c < 2 * n - 1; c++) {
				if (map[r][c] != '0')
					System.out.print(map[r][c]);
				else
					System.out.print(" ");

				if (c != 2 * n - 2)
					System.out.print(" ");
				else
					System.out.println();
			}
		}
	}

	private static void ld(int r, int c, char letter) {
		map[r][c] = letter;

		letter++;
		if (letter > 'Z')
			letter = 'A';

		int newR = r + 1;
		int newC = c - 1;

		if (newC < 0 || (map[r][c - 1] != '0' && map[r + 1][c] != '0')) {
			newC = c + 1;

			if (map[newR][newC] != '0')
				return;
			rd(newR, newC, letter);
		} else {
			ld(newR, newC, letter);
		}

	}

	private static void rd(int r, int c, char letter) {
		map[r][c] = letter;

		letter++;
		if (letter > 'Z')
			letter = 'A';

		int newR = r + 1;
		int newC = c + 1;

		if (newR >= map.length || (map[r + 1][c] != '0' && map[r][c + 1] != '0')) {
			newR = r - 1;

			if (map[newR][newC] != '0')
				return;

			ru(newR, newC, letter);
		} else {
			rd(newR, newC, letter);
		}
	}

	private static void ru(int r, int c, char letter) {
		map[r][c] = letter;

		letter++;
		if (letter > 'Z')
			letter = 'A';

		int newR = r - 1;
		int newC = c + 1;

		if (newC >= map.length || (map[r][c + 1] != '0' && map[r - 1][c] != '0')) {
			newC = c - 1;

			if (map[newR][newC] != '0') {
				if (map[r][c - 1] == '0')
					map[r][c - 1] = letter;
				return;
			}

			lu(newR, newC, letter);
		} else {
			ru(newR, newC, letter);
		}
	}

	private static void lu(int r, int c, char letter) {
		map[r][c] = letter;
		letter++;
		if (letter > 'Z')
			letter = 'A';

		int newR = r - 1;
		int newC = c - 1;

		if (map[newR][newC] != '0') {
			newR = r;
			if (map[newR][newC] != '0')
				return;
			ld(newR, newC, letter);
		} else {
			lu(newR, newC, letter);
		}
	}

}
