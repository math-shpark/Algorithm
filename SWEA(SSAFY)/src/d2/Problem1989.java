package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1989 {

	// 1989. 초심자의 회문 검사
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			String str = br.readLine();

			boolean isCorrect = true;

			char[] original = str.toCharArray();
			char[] reverseArr = new char[original.length];

			for (int i = 0; i < original.length; i++) {
				reverseArr[i] = original[original.length - i - 1];
			}

			for (int i = 0; i < original.length; i++) {
				if (original[i] != reverseArr[i]) {
					isCorrect = false;
				}
			}

			sb.append("#").append(test).append(" ");

			if (isCorrect) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}

		System.out.println(sb);

	}

}
