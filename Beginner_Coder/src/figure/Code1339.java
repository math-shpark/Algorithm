package figure;

import java.util.Scanner;

public class Code1339 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();

		if (n < 1 || n > 100 || n % 2 == 0) {
			System.out.println("INPUT ERROR");
			return;
		}

		char[][] arr = new char[n][(n + 1) / 2];

		char add = 'A';
		int end = 1;
		for (int c = (n + 1) / 2 - 1; c >= 0; c--) {
			for (int r = c; r < c + end; r++) {
				arr[r][c] = add;
				add++;
				if (add > 'Z')
					add = 'A';
			}
			end += 2;
		}

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < (n + 1) / 2; c++) {
				if (arr[r][c] >= 'A' && arr[r][c] <= 'Z') {
					System.out.print(arr[r][c]);
					if (c != (n + 1) / 2 - 1)
						System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

}
