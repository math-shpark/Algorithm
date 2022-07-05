package silver.level3;

import java.util.Scanner;

public class Problem1057 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n, kim, lim;
		n = scan.nextInt(); // N
		kim = scan.nextInt(); // Kim Jimin
		lim = scan.nextInt(); // Lim Hansu

		int result = 0;
		int round = 1;

		while (n != 1) {
			if (kim % 2 == 0) {
				if (lim == kim - 1) {
					result = round;
				}
			} else {
				if (lim == kim + 1) {
					result = round;
				}
			}
			kim = (kim + 1) / 2;
			lim = (lim + 1) / 2;
			round++;
			n = (n + 1) / 2;
		}

		if (result == 0) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

}
