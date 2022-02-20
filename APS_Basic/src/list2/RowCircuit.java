package list2;

import java.util.Scanner;

public class RowCircuit {

	// 행 우선 순회
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int[][] arr = new int[5][7];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				arr[i][j] = scan.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(arr[i][j] + " ");
			}

			System.out.println();
		}

		scan.close();

	}

}
