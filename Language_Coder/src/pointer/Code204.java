package pointer;

import java.util.Scanner;

public class Code204 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int max = scan.nextInt(), min = max;

		for (int i = 1; i < n; i++) {
			int num = scan.nextInt();
			if (num > max)
				max = num;
			if (num < min)
				min = num;
		}

		System.out.println("max : " + max);
		System.out.println("min : " + min);
	}

}
