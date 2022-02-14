package level5;

import java.util.Scanner;

public class Problem9239 {

	// 9239. 스티브 잡숭
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		double x = scan.nextDouble();
		boolean isNoSolution = true;
		int range = 0;

		for (int i = 0; i < 8; i++) {

			range = (int) Math.pow(10, i);

			for (int j = range; j < range * 10; j++) {

				if (j * x != (int) j * x) {
					continue;
				}

				int newNum = j % range * 10 + j / range;
				if (j * x == newNum) {
					System.out.println(j);
					isNoSolution = false;
				}
			}
		}

		if (isNoSolution) {
			System.out.println("No solution");
		}

	}

}
