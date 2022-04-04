package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15652 {

	// 문자열 생성
	static StringBuilder sb = new StringBuilder();
	// 뽑은 수를 저장할 배열
	static int[] arr;
	// 수의 범위
	static int N;
	// 뽑을 수의 개수
	static int M;

	// 15652. N과 M (4)
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		dfs(1, 0);

		// 결과 출력
		System.out.println(sb);

	}

	// dfs
	private static void dfs(int start, int count) {

		// 경계
		// 뽑은 수의 개수가 원하는 수의 개수면 재귀 종료
		if (count == M) {
			for (int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append('\n');
			return;
		}

		// 재귀
		// 다음 수 뽑기
		// 중복 허용
		for (int i = start; i <= N; i++) {
			arr[count] = i;
			// 중복을 허용해야 하므로 start 값을 유지
			dfs(i, count + 1);
		}

	}

}
