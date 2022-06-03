package string;

import java.util.Scanner;

public class Code612 {

	public static void main(String[] args) {
		String str = "";

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			str += String.valueOf(scan.nextInt());
		}

		for (int i = 0; i < str.length(); i += 3) {
			System.out.print(str.charAt(i));
			if (i + 1 < str.length())
				System.out.print(str.charAt(i + 1));
			if (i + 2 < str.length())
				System.out.print(str.charAt(i + 2));
			System.out.println();
		}

		scan.close();
	}

}
