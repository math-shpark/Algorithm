package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9251 {

	static char[] str1;
	static char[] str2;
	static Integer[][] dp;

	// 9251. LCS
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		str1 = br.readLine().toCharArray();
		str2 = br.readLine().toCharArray();

		dp = new Integer[str1.length][str2.length];

		System.out.println(LCS(str1.length - 1, str2.length - 1));

	}

	// LCS
	private static int LCS(int row, int col) {

		if (row == -1 || col == -1) {
			return 0;
		}

		if (dp[row][col] == null) {
			dp[row][col] = 0;

			if (str1[row] == str2[col]) {
				dp[row][col] = LCS(row - 1, col - 1) + 1;
			} else {
				dp[row][col] = Math.max(LCS(row - 1, col), LCS(row, col - 1));
			}
		}

		return dp[row][col];
	}

}
