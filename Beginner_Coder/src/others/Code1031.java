package others;

import java.util.Scanner;

public class Code1031 {

	static int[][] board;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		board = new int[5][5];

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				board[r][c] = scan.nextInt();
			}
		} // board data input

		int result = 0;

		Outer: for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int call = scan.nextInt();
				check(call);
				int count = 0;
				count += row();
				count += col();
				count += diagonal();

				if (count >= 3) {
					result = 5 * i + j;
					break Outer;
				}
			}
		}

		System.out.println(result + 1);
	}

	private static int diagonal() {
		int result = 0;

		boolean left = true;
		boolean right = true;

		for (int i = 0; i < 5; i++) {
			if (board[i][i] != -1)
				left = false;
			if (board[i][4 - i] != -1)
				right = false;
		}

		if (left)
			result++;
		if (right)
			result++;

		return result;
	}

	private static int col() {
		int result = 0;

		for (int c = 0; c < 5; c++) {
			boolean isOkay = true;
			for (int r = 0; r < 5; r++) {
				if (board[r][c] != -1) {
					isOkay = false;
					break;
				}
			}
			if (isOkay)
				result++;
		}
		return result;
	}

	private static int row() {
		int result = 0;

		for (int r = 0; r < 5; r++) {
			boolean isOkay = true;
			for (int c = 0; c < 5; c++) {
				if (board[r][c] != -1) {
					isOkay = false;
					break;
				}
			}
			if (isOkay)
				result++;
		}
		return result;
	}

	private static void check(int call) {
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (board[r][c] == call) {
					board[r][c] = -1;
					return;
				}
			}
		}
	}

}
