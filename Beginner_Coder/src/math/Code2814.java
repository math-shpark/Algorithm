package math;

import java.util.Scanner;

public class Code2814 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();

		String[] arr = str.split("");

		int result = 0;
		
		for (int i = 0; i < arr.length; i++) {
			int pow = arr.length - i - 1;
			int num = (int) Math.pow(2, pow);
			if (arr[i].equals("1"))
				result += num;
		}

		System.out.println(result);
	}

}
