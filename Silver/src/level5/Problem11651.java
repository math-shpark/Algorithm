package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem11651 {

	// 11651. 좌표 정렬하기 2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 좌표 개수
		int N = Integer.parseInt(br.readLine());
		// 좌표 정보를 저장할 배열
		int[][] coordinates = new int[N][2];

		// 좌표 정보를 배열에 저장
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			coordinates[i][0] = x;
			coordinates[i][1] = y;
		}

		// 제시된 기준에 맞춰 배열 정렬
		Arrays.sort(coordinates, new Comparator<int[]>() {
			public int compare(int[] c1, int[] c2) {
				if (c1[1] == c2[1]) {
					return c1[0] - c2[0];
				} else {
					return c1[1] - c2[1];
				}
			}
		});

		// 결과 출력
		for (int i = 0; i < N; i++) {
			sb.append(coordinates[i][0]).append(" ").append(coordinates[i][1]).append('\n');
		}

		System.out.println(sb);

	}

}
