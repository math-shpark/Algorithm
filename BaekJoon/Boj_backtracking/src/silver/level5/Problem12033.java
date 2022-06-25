package silver.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12033 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine()); // testCase

		for (int t = 0; t < tc; t++) {
			int item = Integer.parseInt(br.readLine()); // item count
			int[] arr = new int[item * 2];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 2 * item; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			sb.append("Case #").append(t + 1).append(":");

			int count = 0;

			for (int i = 0; i < 2 * item; i++) {
				if (count == item)
					break;
				if (arr[i] == -1)
					continue;
				int num = arr[i];
				count++;
				sb.append(" ").append(num);

				int origin = (num / 3) * 4;

				for (int j = i + 1; j < 2 * item; j++) {
					if (arr[j] == origin) {
						arr[j] = -1;
						break;
					}
				}
			}

			sb.append('\n');
		}

		System.out.println(sb); // print
	}

}
