package string;

import java.util.Scanner;

public class Code2514 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String input = scan.next(); // data

		if (input.length() < 3) {
			System.out.println(0);
			System.out.println(0);
			return;
		} // operation condition

		System.out.println(findWord(input, "KOI"));
		System.out.println(findWord(input, "IOI"));
	}

	private static int findWord(String input, String compare) {

		int result = 0;

		for (int i = 0; i < input.length() - 2; i++) {
			String str = input.substring(i, i + 3);
			if (str.equals(compare))
				result++;
		}

		return result;
	}

}
