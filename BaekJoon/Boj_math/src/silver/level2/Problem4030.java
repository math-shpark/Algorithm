package silver.level2;

import java.util.Scanner;

// 4030. 포켓볼
public class Problem4030 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int idx = 1;

		while (true) {
			int a, b;
			a = scan.nextInt();
			b = scan.nextInt();

			if (a == 0 && b == 0)
				break;

			int count = 0;
			int x = 0;
			int square = 0;

			sb.append("Case ").append(idx).append(": ");

			for (int i = 1; i < 44721; i++) {
				x = i * (i + 1) / 2;

				if (x >= a) {
					if (x >= b - 1) {
						break;
					}

					square = x + 1;

					if (square == (int) Math.sqrt(square) * (int) Math.sqrt(square)) {
						count++;
					}
				}
			}

			sb.append(count).append('\n');

			idx++;

		}

		System.out.println(sb);
	}

}
