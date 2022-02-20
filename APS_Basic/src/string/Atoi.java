package string;

import java.util.Scanner;

public class Atoi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String num = scan.next();

		int value = 0;
		boolean isPositive = true;
		int digit;

		for (int i = 0; i < num.length(); i++) {

			if (num.charAt(0) == '-') {
				isPositive = false;
				continue;
			}

			digit = num.charAt(i) - '0';

			value = (value * 10) + digit;

		}

		if (!isPositive) {
			value = (-1) * value;
		}

		System.out.println(value);

		scan.close();

	}
}
