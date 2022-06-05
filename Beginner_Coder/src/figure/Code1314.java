package figure;

import java.util.Scanner;

public class Code1314 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		char[][] arr = new char[n][n];

		char add = 'A';

		for (int c = 0; c < n; c++) {
			int plus = c % 2 == 0 ? 1 : -1;
			for (int r = c % 2 == 0 ? 0 : n - 1; c % 2 == 0 ? r < n : r >= 0; r += plus) {
				arr[r][c] = add;
				add++;
				if (add > 'Z')
					add = 'A';
			}
		}

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				System.out.print(arr[r][c]);
				if (c != n - 1)
					System.out.print(" ");
				else
					System.out.println();
			}
		}
	}

}
