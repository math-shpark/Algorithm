package conditional;

import java.util.Scanner;

public class Code632 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1, num2, num3, min;
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		num3 = scan.nextInt();

		min = num1 < num2 ? num1 : num2;
		min = min < num3 ? min : num3;

		System.out.println(min);
	}

}
