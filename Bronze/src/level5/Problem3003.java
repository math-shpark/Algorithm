package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3003 {

	// 3003. 킹, 퀸, 룩, 비숍, 나이트, 폰
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int[] peace = { 1, 1, 2, 2, 2, 8 };

		for (int i = 0; i < 6; i++) {
			sb.append(peace[i] - Integer.parseInt(st.nextToken())).append(" ");
		}

		System.out.println(sb);

	}

}
