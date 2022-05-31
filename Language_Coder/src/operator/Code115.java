package operator;

import java.util.Scanner;

public class Code115 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int[][] info = new int[2][2];

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				info[i][j] = scan.nextInt();
			}
		}

		boolean result = false;

		if (info[0][0] > info[1][0] && info[0][1] > info[1][1])
			result = true;

		System.out.println(result);
	}

}
