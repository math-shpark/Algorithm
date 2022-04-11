package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15649 {

	static int N, M;
	static boolean[] isSelected;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	// 15649. N과 M (1)
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 매개변수 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		selected = new int[M];
		isSelected = new boolean[N];

		// 순열
		permutation(0);

		System.out.println(sb);
	}

	private static void permutation(int count) {
		// 경계
		if (count == M) {
			for (int num : selected) {
				sb.append(num + 1).append(" ");
			}
			sb.append('\n');
			return;
		}

		// 재귀
		for (int i = 0; i < N; i++) {
			if (!isSelected[i]) {
				isSelected[i] = true;
				selected[count] = i;
				permutation(count + 1);
				isSelected[i] = false;
			}
		}
	}

}
