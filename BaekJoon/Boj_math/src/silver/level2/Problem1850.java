package silver.level2;

import java.util.Scanner;

public class Problem1850 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		long a, b;
		a = scan.nextLong();
		b = scan.nextLong();

		if (a < b) {
			long temp = a;
			a = b;
			b = temp;
		}

		while (b > 0) {
			long temp = a;
			a = b;
			b = temp % b;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < a; i++) {
			sb.append(1);
		}

		System.out.println(sb);

	}

}
