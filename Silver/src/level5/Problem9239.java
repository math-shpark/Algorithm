package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9239 {

	// 9239. 스티브 잡숭
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		double multi = Double.parseDouble(br.readLine());

		boolean isNoSolution = true;

		for (int i = 0; i < 8; i++) {

			int range = (int) Math.pow(10, i);

			for (int j = range; j < range * 10; j++) {
				int num1 = j / range;
				int num2 = j - num1 * range;

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

	}

}
