package others;

import java.util.Scanner;

public class Code1438 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num = scan.nextInt(); // the number of papers
		int[][] paper = new int[101][101];

		for (int i = 0; i < num; i++) {
			int col = scan.nextInt();
			int row = scan.nextInt();

			for (int r = 100 - row; r > 90 - row; r--) {
				for (int c = col; c < col + 10; c++) {
					paper[r][c] = 1;
				}
			}
		}

		int area = 0;

		for (int r = 0; r <= 100; r++) {
			for (int c = 0; c <= 100; c++) {
				if (paper[r][c] == 1)
					area++;
			}
		}

		System.out.println(area);
	}

}
