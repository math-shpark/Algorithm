package string;

import java.util.Scanner;

public class Code237 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int i = scan.nextInt();
		double d = scan.nextDouble();
		String str = scan.next();

		d = Math.round(d * 1000) / 1000.0; // 반올림

		String total = String.valueOf(i) + String.valueOf(d) + str;
		int cut = total.length() % 2 == 0 ? total.length() / 2 : total.length() / 2 + 1;

		System.out.println(total.substring(0, cut));
		System.out.println(total.substring(cut, total.length()));
	}

}
