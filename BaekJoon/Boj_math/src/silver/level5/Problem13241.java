package silver.level5;

import java.util.Scanner;

public class Problem13241 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		long a, b;
		a = scan.nextLong();
		b = scan.nextLong();

		long gcd = gcd(Math.max(a, b), Math.min(a, b));

		System.out.println((a * b) / gcd);
	}

	private static long gcd(long b, long s) {

		while (s > 0) {
			long temp = b;
			b = s;
			s = temp % s;
		}

		return b;
	}

}
