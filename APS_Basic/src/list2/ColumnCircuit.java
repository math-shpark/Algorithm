package list2;

import java.util.Scanner;

public class ColumnCircuit {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[][] arr = new int[5][7];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				arr[i][j] = scan.nextInt();
			}
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(arr[j][i] + " ");
			}

			System.out.println();
		}

		scan.close();

	}

}
