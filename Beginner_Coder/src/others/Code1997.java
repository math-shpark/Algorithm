package others;

import java.util.Scanner;

public class Code1997 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int d = scan.nextInt();
		int k = scan.nextInt();

		int[][] arr = new int[d][2];

		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;

		for (int i = 2; i < d; i++) {
			arr[i][0] = arr[i - 1][0] + arr[i - 2][0];
			arr[i][1] = arr[i - 1][1] + arr[i - 2][1];
		}

		int a = 1;
		int b = 1;

		while (true) {
			if ((k - arr[d - 1][0] * a) % arr[d - 1][1] == 0) {
				b = (k - arr[d - 1][0] * a) / arr[d - 1][1];
				break;
			}
			a++;
		}

		System.out.println(a);
		System.out.println(b);

	}

}
