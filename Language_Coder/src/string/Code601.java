package string;

import java.util.Scanner;

public class Code601 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		char[] arr = scan.next().toCharArray();

		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < arr.length; j++) {
				sb.append(arr[(i + j) % arr.length]);
			}
			sb.append('\n');
		}

		System.out.println(sb);

	}

}
