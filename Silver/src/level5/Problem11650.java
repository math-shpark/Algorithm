package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem11650 {

	// 11650. 좌표 정렬하기
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// N 입력
		int N = Integer.parseInt(br.readLine());
		// 좌표를 저장할 배열
		int[][] coordinates = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 좌표 입력
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			coordinates[i][0] = x;
			coordinates[i][1] = y;
		}

		// 문제에서 제시하는 조건에 맞춰 정렬
		Arrays.sort(coordinates, new Comparator<int[]>() {
			public int compare(int[] c1, int[] c2) {
				// x 좌표가 동일하면
				if (c1[0] == c2[0]) {
					// y 좌표 기준으로 오름차순
					return c1[1] - c2[1];
				}
				
				// 아니면 x 좌표 기준 오름차순
				return c1[0] - c2[0];
			}
		});

		// 결과 출력
		for (int i = 0; i < N; i++) {
			sb.append(coordinates[i][0]).append(" ").append(coordinates[i][1]).append('\n');
		}

		System.out.println(sb);

	}

}
