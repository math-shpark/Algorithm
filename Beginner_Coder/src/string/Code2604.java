package string;

import java.util.Scanner;

public class Code2604 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String input = scan.nextLine(); // data
		int height = 10;

		for (int i = 1; i < input.length(); i++) {
			char prev = input.charAt(i - 1);
			char now = input.charAt(i);

			if (prev == now)
				height += 5;
			else
				height += 10;
		} // height calculation
		
		System.out.println(height); // print
	}

}
