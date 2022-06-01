package loop;

import java.util.Scanner;

public class Code149 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int num = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(num);
				num += 2;
				num %= 10;
				if (j != n - 1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
