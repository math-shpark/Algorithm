package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1233 {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test = 1; test <= 10; test++) {
			int N = Integer.parseInt(br.readLine());

			boolean isPossible = true;

			for (int i = 1; i <= N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int nodeNum = Integer.parseInt(st.nextToken());

				char data = st.nextToken().charAt(0);

				if (st.hasMoreTokens()) {
					if (data >= '0' && data <= '9') {
						isPossible = false;
					}
				} else {
					if (data < '0' || data > '9') {
						isPossible = false;
					}
				}
			}

			sb.append("#").append(test).append(" ");

			if (isPossible) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}

		System.out.println(sb);
	}

}
