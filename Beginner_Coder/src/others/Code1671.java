package others;

import java.util.Scanner;

public class Code1671 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int paperCnt;
		int x, y;
		int cnt = 0;
		int paper[][] = new int[101][101];
		int i, j;

		paperCnt = scan.nextInt();
		while (paperCnt-- > 0) {
			y = scan.nextInt();
			x = scan.nextInt();

			for (i = y; i < y + 10; i++) {
				for (j = x; j < x + 10; j++) {
					paper[i][j] = 1;
				}
			}

		}

		for (i = 0; i < 101; i++) {
			for (j = 0; j < 101; j++) {
				if (paper[i][j] == 1) {
					if (paper[i + 1][j] == 0) {
						cnt++;
					}
					if (paper[i - 1][j] == 0) {
						cnt++;
					}
					if (paper[i][j + 1] == 0) {
						cnt++;
					}
					if (paper[i][j - 1] == 0) {
						cnt++;
					}
				}

			}
		}

		System.out.println(cnt);

	}
}
