package level5;

import java.io.IOException;
import java.util.Scanner;

public class Problem9239 {

	// 9239. 스티브 잡숭
	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner scan = new Scanner(System.in);

		double multi = scan.nextDouble();

		int count = 0;

		for (int i = 0; i < 8; i++) {

			int range = (int) Math.pow(10, i);

			for (int j = range; j < range * 10; j++) {

				int num1 = j / range;
				int num2 = j % range;

				int newNum = num2 * 10 + num1;

				if (multi * j == newNum) {
					System.out.println(j);
					count++;
				}
			}
		}

		if (count == 0) {
			System.out.println("No solution");
		}

		scan.close();

	}
}
