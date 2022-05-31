package input;

import java.util.Scanner;

public class Code517 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			double num = scan.nextDouble();

			System.out.printf("%.3f\n", num);
		}
	}

}
