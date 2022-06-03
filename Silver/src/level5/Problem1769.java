package level5;

import java.util.Scanner;

public class Problem1769 {

	static boolean isOkay = false;

	// 1769. 3의 배수
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String str = scan.nextLine();

		op(str, 0);

		if (isOkay)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	private static void op(String str, int count) {
		int num = 0;

		if (str.length() < 2) {
			num = Integer.parseInt(str);
			isOkay = num % 3 == 0;
			System.out.println(count);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			num += str.charAt(i) - '0';
		}
		str = String.valueOf(num);
		op(str, count + 1);
	}

}
