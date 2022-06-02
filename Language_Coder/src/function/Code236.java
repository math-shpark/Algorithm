package function;

import java.util.Scanner;

public class Code236 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int num1, num2, num3;

		num1 = scan.nextInt();
		num2 = scan.nextInt();
		num3 = scan.nextInt();

		int mul = num1 * num2 * num3;
		String str = String.valueOf(mul);

		int result = 1;
		for (int i = 0; i < str.length(); i++) {
			char num = str.charAt(i);
			if (num == '0')
				continue;
			result *= num - '0';
		}

		System.out.println(result);
	}

}
