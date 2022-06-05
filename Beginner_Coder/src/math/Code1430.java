package math;

import java.util.Scanner;

public class Code1430 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int A, B, C;
		A = scan.nextInt();
		B = scan.nextInt();
		C = scan.nextInt();

		String str = String.valueOf(A * B * C);

		for (int i = 0; i <= 9; i++) {
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) - '0' == i)
					count++;
			}
			System.out.println(count);
		}
	}

}
