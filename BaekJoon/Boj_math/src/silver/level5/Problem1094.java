package silver.level5

import java.util.Scanner;

public class Problem1094 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int x = scan.nextInt();
		int count = 0;
		int stick = 64;

		while (x > 0) {
			if (stick > x)
				stick /= 2;
			else {
				count++;
				x -= stick;
			}
		}

		System.out.println(count);
	}

}
