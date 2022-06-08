package math;

import java.util.Scanner;

public class Code2811 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 5; i++) {
			int num = scan.nextInt();

			if (num == 1) {
				sb.append("number one").append('\n');
				continue;
			}

			if (check(num))
				sb.append("prime number").append('\n');
			else
				sb.append("composite number").append('\n');
		}

		System.out.println(sb);
	}

	private static boolean check(int num) {

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
