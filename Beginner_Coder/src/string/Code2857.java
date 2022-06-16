package string;

import java.util.Scanner;

public class Code2857 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		char[][] board = new char[5][15];

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 15; c++) {
				board[r][c] = '-';
			}
		}

		int maxSize = 0;

		for (int i = 0; i < 5; i++) {
			String str = scan.nextLine();

			if (str.length() > maxSize)
				maxSize = str.length();

			for (int j = 0; j < str.length(); j++) {
				board[i][j] = str.charAt(j);
			}
		} // data

		String result = "";

		for (int c = 0; c < maxSize; c++) {
			for (int r = 0; r < 5; r++) {
				if (board[r][c] == '-')
					continue;
				result += board[r][c];
			}
		} // connect

		System.out.println(result); // print
	}

}
