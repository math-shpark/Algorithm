package math;

import java.util.Scanner;

public class Code4977 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		double num = scan.nextDouble(); // number

		int intPart = (int) num;
		double floatPart = num - intPart;

		String result1 = ""; // integer part result

		while (intPart >= 2) {
			result1 = intPart % 2 + result1;
			intPart /= 2;
		}

		result1 = intPart + result1;

		String result2 = ""; // float part result

		while (floatPart != 0) {
			result2 += (int) (floatPart * 2);

			if (result2.length() == 4)
				break;

			floatPart *= 2;

			if (floatPart >= 1)
				floatPart -= 1;
		}

		while (result2.length() != 4) {
			result2 += "0";
		}

		System.out.println(result1 + "." + result2); // print
	}

}
