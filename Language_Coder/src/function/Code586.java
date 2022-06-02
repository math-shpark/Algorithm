package function;

import java.util.Scanner;

public class Code586 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1, num2;
		num1 = scan.nextInt();
		num2 = scan.nextInt();

		System.out.printf("(%d - %d) ^ 2 = %d\n", num1, num2, (int) Math.pow(num1 - num2, 2));
		System.out.printf("(%d + %d) ^ 3 = %d", num1, num2, (int) Math.pow(num1 + num2, 3));

	}

}
