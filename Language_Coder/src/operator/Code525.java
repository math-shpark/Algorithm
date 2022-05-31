package operator;

import java.util.Scanner;

public class Code525 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int maxNum = scan.nextInt();

		boolean result1 = false;
		boolean result2 = false;

		int num2 = scan.nextInt();
		int num3 = scan.nextInt();

		if (maxNum > num2 && maxNum > num3)
			result1 = true;

		if (maxNum == num2 && num2 == num3)
			result2 = true;

		System.out.println(result1 + " " + result2);

	}

}
