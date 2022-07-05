package others;

import java.util.Scanner;

public class Code1761 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt(); // N

		int[][] arr = new int[n][3];

		for (int i = 0; i < n; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
			arr[i][2] = scan.nextInt();
		} // data input

		int num = 123;
		int count = 0;

		Outer: while (num < 1000) {
			boolean isOkay = true;

			int[] numArr = new int[3];
			numArr[0] = num / 100;
			numArr[1] = (num % 100) / 10;
			numArr[2] = num % 10;

			num++;

			for (int i = 0; i < 3; i++) {
				if (numArr[i] == 0)
					continue Outer;
				else {
					for (int j = 1; j <= 2; j++) {
						if (numArr[i] == numArr[(i + j) % 3])
							continue Outer;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				int[] now = new int[3];
				int strike = 0;
				int ball = 0;

				now[0] = arr[i][0] / 100;
				now[1] = (arr[i][0] % 100) / 10;
				now[2] = arr[i][0] % 10;

				for (int j = 0; j < 3; j++) {
					if (numArr[j] == now[j])
						strike++;
					else if (numArr[j] == now[(j + 1) % 3] || numArr[j] == now[(j + 2) % 3])
						ball++;
				}

				if (arr[i][1] != strike || arr[i][2] != ball) {
					isOkay = false;
					break;
				}
			}

			if (isOkay) {
				count++;
			}
		}

		System.out.println(count);
	}

}
