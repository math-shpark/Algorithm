package function;

import java.util.Scanner;

public class Code174 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[][] score = new int[4][4];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				if (j != 3) {
					score[i][j] = scan.nextInt();
					score[i][3] += score[i][j];
				}
				score[3][j] += score[i][j];
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(score[i][j]);
				if (j != 3)
					System.out.print(" ");
			}
			System.out.println();
		}

	}

}
