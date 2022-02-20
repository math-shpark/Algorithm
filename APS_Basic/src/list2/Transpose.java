package list2;

import java.util.Scanner;

public class Transpose {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[][] arr = new int[5][7];
		int[][] transpose = new int[7][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				arr[i][j] = scan.nextInt();
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				transpose[i][j] = arr[j][i];
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(transpose[i][j] + " ");
			}

			System.out.println();
		}

		scan.close();

	}

}
