package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11403 {

	// 11403. 경로 찾기
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 공간 크기 입력
		int N = Integer.parseInt(br.readLine());

		// 공간 배열 생성
		int[][] space = new int[N][N];

		// 공간 정보를 배열에 저장하는 반복문
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 출발점과 도착점이 바로 연결되는 것과
		// 중간점을 거쳐 연결되는 것은 결과적으로 동일함
		// 이미 저장된 연결 정보를 활용하여 두 점이 하나의 중간점을 거쳐 연결되는 것도
		// 직접 연결되는 것과 동일하게 간주하여 공간 배열 정보에 연결 정보 추가
		for (int mid = 0; mid < N; mid++) {
			for (int start = 0; start < N; start++) {
				for (int end = 0; end < N; end++) {
					if (space[start][mid] == 1 && space[mid][end] == 1) {
						space[start][end] = 1;
					}
				}
			}
		}

		// 결과 문자열 생성 반복문
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j == N - 1) {
					sb.append(space[i][j]).append('\n');
				} else {
					sb.append(space[i][j]).append(" ");
				}
			}
		}

		System.out.println(sb);

	}

}
