package level5;

import java.util.Scanner;

public class Problem9239 {

	// 9239. 스티브 잡숭
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		double multi = scan.nextDouble();

		boolean isNoSolution = true;

		for (int i = 0; i < 8; i++) {

			for (int j = (int) Math.pow(10, i); j < Math.pow(10, i + 1); j++) {
				int num1 = j / (int) Math.pow(10, i);
				int num2 = j - num1 * (int) Math.pow(10, i);

				int newNum = num2 * 10 + num1;

				if (multi * j == newNum) {
					System.out.println(j);
					isNoSolution = false;
				}
			}
		}

		if (isNoSolution) {
			System.out.println("No solution");
		}

		scan.close();

	}

}
