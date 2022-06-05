package figure;

import java.util.Scanner;

public class Code1329 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		if (n <= 0 || n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR!");
			return;
		}

		char[][] map = new char[n][n + n / 2];
		int startIdx = 0;
		int add = 1;
		int starCount = 1;

		for (int r = 0; r < n; r++) {
			for (int c = startIdx; c < startIdx + starCount; c++) {
				map[r][c] = '*';
			}
			if (starCount == n) {
				add = -1;
			}
			startIdx += add;
			starCount += add * 2;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n + n / 2; j++) {
				if (map[i][j] == '*')
					System.out.print('*');
				else
					System.out.print(" ");
			}
			System.out.println();
		}

	}

}
