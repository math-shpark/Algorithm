package array;

public class Code570 {

	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 1, 1, 1 }, { 1, 2, 3, 4, 5 }, { 1, 3, 6, 10, 15 }, { 1, 4, 10, 20, 35 },
				{ 1, 5, 15, 35, 70 } };

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(arr[i][j]);
				if (j != 4)
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
