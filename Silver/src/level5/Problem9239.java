package level5;

import java.util.Scanner;

public class Problem9239 {

	// 9239. 스티브 잡숭
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		double multi = scan.nextDouble();

		for (int i = 0; i < 8; i++) {
			for (int j = (int) Math.pow(10, i); j < Math.pow(10, i + 1); j++) {
				int newNum = (j - (j / (int) Math.pow(10, i)) * (int) Math.pow(10, i)) * 10
						+ (j / (int) Math.pow(10, i));

				if (multi * j == newNum) {
					System.out.println(j);
				}
			}
		}

		scan.close();

	}

}
