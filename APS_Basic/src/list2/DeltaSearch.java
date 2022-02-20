package list2;

import java.util.Scanner;

public class DeltaSearch {

	public static void main(String[] args) {

		// 상하좌우 순
		int dr[] = { -1, 1, 0, 0 };
		int dc[] = { 0, 0, -1, 1 };

		Scanner scan = new Scanner(System.in);

		int[][] arr = new int[5][7];
		int[][] sumArr = new int[5][7];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				arr[i][j] = scan.nextInt();
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				int sum = 0;
				for (int k = 0; k < 4; k++) {
					int newRow = i + dr[k];
					int newCol = j + dc[k];

					if (newRow < 0 || newRow >= 5 || newCol < 0 || newCol >= 7) {
						continue;
					} else {
						sum += arr[newRow][newCol];
					}
				}
				sumArr[i][j] = sum;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(sumArr[i][j] + " ");
			}

			System.out.println();
		}
		
		scan.close();

	}

}
