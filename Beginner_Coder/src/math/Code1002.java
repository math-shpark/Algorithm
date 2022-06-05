package math;

import java.util.Scanner;

public class Code1002 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int N = scan.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = scan.nextInt();
		}

		int gcd = calGcd(arr[0], arr[1]);
		int lcm = calLcm(arr[0], arr[1]);

		for (int i = 2; i < N; i++) {
			gcd = calGcd(gcd, arr[i]);
			lcm = calLcm(lcm, arr[i]);
		}

		System.out.println(gcd + " " + lcm);
	}

	// Least Common Multiple
	private static int calLcm(int a, int b) {
		int gcd = calGcd(a, b);
		int lcm = (a / gcd) * (b / gcd) * gcd;
		return lcm;
	}

	// Greatest Common Divisor
	private static int calGcd(int a, int b) {
		int range = a <= b ? a : b;

		int gcd = 1;
		for (int i = 1; i <= range; i++) {
			if (a % i == 0 && b % i == 0)
				gcd = i;
		}

		return gcd;
	}

}
