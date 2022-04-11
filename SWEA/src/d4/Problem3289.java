package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3289 {

	// 상호 배타 배열
	static int[] p;

	// 3289. 서로소 집합
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			// 출력 양식
			sb.append("#").append(test).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 매개 변수 입력
			// 집합 개수
			int n = Integer.parseInt(st.nextToken());
			// 연산 수
			int m = Integer.parseInt(st.nextToken());

			p = new int[n + 1];

			// 집합 만들기
			for (int i = 0; i < n + 1; i++) {
				p[i] = i;
			}

			// 연산 수행
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				// 연산
				int command = Integer.parseInt(st.nextToken());
				// 매개변수
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (command == 0) {
					union(x, y);
				} else {
					if (findSet(x) == findSet(y)) {
						sb.append(1);
					} else
						sb.append(0);
				}
			}

			// 줄바꿈
			sb.append("\n");

		}

		// 결과 출력
		System.out.println(sb);
	}

	// 대표자 탐색
	private static int findSet(int x) {
		// path compression
		if (x == p[x])
			return x;

		return p[x] = findSet(p[x]);
	}

	// 합집합
	private static void union(int x, int y) {

		int root1 = findSet(x);
		int root2 = findSet(y);

		// 같은 집합이면 건너뛰기
		if (root1 == root2)
			return;

		// 다른 집합이면 연결
		p[root2] = root1;
	}
}
