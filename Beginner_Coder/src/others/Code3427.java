package others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Code3427 {

	private static int n;
	private static char[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine()); // N
		arr = new char[n];
		String str = br.readLine();

		for (int i = 0; i < n; i++) {
			arr[i] = str.charAt(i);
		}

		int minVal = move('R', 0);
		minVal = minVal < move('R', n - 1) ? minVal : move('R', n - 1);
		minVal = minVal < move('B', 0) ? minVal : move('B', 0);
		minVal = minVal < move('B', n - 1) ? minVal : move('B', n - 1);

		System.out.println(minVal);

	}

	private static int move(char color, int idx) {

		int count = 0;
		int add = idx == 0 ? 1 : -1;
		boolean isSame = true;

		if (arr[idx] != color)
			isSame = false;

		int i = idx == 0 ? 1 : n - 2;

		for (; idx == 0 ? i < n : i >= 0; i += add) {
			if (arr[i] == color) {
				if (!isSame) {
					count++;
				}
			} else {
				isSame = false;
			}
		}

		return count;
	}

}
