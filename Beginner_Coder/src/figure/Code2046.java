package figure;

import java.util.Scanner;

public class Code2046 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int m = scan.nextInt();

		switch (m) {
		case 1:
			for (int r = 1; r <= n; r++) {
				for (int c = 1; c <= n; c++) {
					System.out.print(r);
					if (c != n)
						System.out.print(" ");
					else
						System.out.println();
				}
			}
			break;
		case 2:
			for (int r = 1; r <= n; r++) {
				int add = r % 2 == 0 ? -1 : 1;
				int end = r % 2 == 0 ? 1 : n;
				for (int c = r % 2 == 0 ? n : 1; r % 2 == 0 ? c >= 1 : c <= n; c += add) {
					System.out.print(c);
					if (c != end)
						System.out.print(" ");
					else
						System.out.println();
				}
			}
			break;
		case 3:
			for (int r = 1; r <= n; r++) {
				for (int c = r; c <= n * r; c += r) {
					System.out.print(c);
					if (c != n * r)
						System.out.print(" ");
					else
						System.out.println();
				}
			}
			break;
		}

	}

}
