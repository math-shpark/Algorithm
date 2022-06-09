package math;

import java.util.Scanner;

public class Code1534 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int before = scan.nextInt();
		int num = scan.nextInt();

		String result = "";

		while (before >= num) {
			if (before % num >= 10) {
				char add = (char) ('A' + (before % num - 10));
				result = add + result;
			} else
				result = before % num + result;
			before /= num;
		}

		result = before + result;

		System.out.println(result);

	}

}
