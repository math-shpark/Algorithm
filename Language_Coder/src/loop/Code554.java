package loop;

import java.util.Scanner;

public class Code554 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int num = 1;
		char eng = 'A';

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < (n - i); j++) {
				System.out.print(num + " ");
				num++;
			}
			for (int j = 0; j < (i + 1); j++) {
				System.out.print(eng);
				eng++;
				if (j != i)
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
