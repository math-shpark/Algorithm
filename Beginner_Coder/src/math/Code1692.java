package math;

import java.util.Scanner;

public class Code1692 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1, num2;
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		System.out.println(num1 * (num2 % 10));
		System.out.println(num1 * ((num2 % 100) / 10));
		System.out.println(num1 * (num2 / 100));
		System.out.println(num1 * num2);
	}

}
