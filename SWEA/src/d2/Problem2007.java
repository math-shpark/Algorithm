package d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2007 {

	// 2007. 패턴 마디의 길이
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			String str = br.readLine();
			char[] strArr = str.toCharArray();

			int patternLength = 0;

			char start = strArr[0];

			Outer: for (int i = 1; i < strArr.length; i++) {
				if (start == strArr[i]) {
					for (int j = 0; j < i; j++) {
						if (strArr[0 + j] != strArr[i + j]) {
							continue Outer;
						}
					}
					patternLength = i;
					break;
				}
			}

			System.out.println("#" + test + " " + patternLength);
		}

	}

}
