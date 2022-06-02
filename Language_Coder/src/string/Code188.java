package string;

import java.util.Scanner;

public class Code188 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String str = scan.nextLine();
		String[] arr = str.split(" ");

		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + ". " + arr[i]);
		}
	}

}
