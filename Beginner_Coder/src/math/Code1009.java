package math;

import java.util.Scanner;

public class Code1009 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true) {
			String str = scan.nextLine();

			if (str.equals("0"))
				break;

			String reverse = "";
			int sum = 0;
			for (int i = str.length() - 1; i >= 0; i--) {
				reverse += str.charAt(i);
				sum += (int) (str.charAt(i) - '0');
			}
			System.out.println(Integer.parseInt(reverse) + " " + sum);
		}
	}

}
