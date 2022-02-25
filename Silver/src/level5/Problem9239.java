package level5;

import java.util.Scanner;

public class Problem9239 {

	// 9239. 스티브 잡숭
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		double x = scan.nextDouble();
		boolean isNoSolution = true;
		double pow = 1;

		if (x < 10) {
			for (int i = 0; i < 8; i++) {
				for (double j = pow * 1; j < pow * 10; j++) {
					int a0 = (int) (j / pow);
					if (j == ((pow * 10 - 1) / (10 - x)) * a0) {
						sb.append((int) j).append('\n');
						isNoSolution = false;
					}
				}
				pow = pow * 10;
			}
		}

		if (isNoSolution) {
			System.out.println("No solution");
		} else {
			System.out.println(sb);
		}

		scan.close();

	}

}