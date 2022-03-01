package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18111 {

	// 18111. 마인크래프트
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		// N, M, B 입력
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		// 맵 정보 배열
		int[][] map = new int[N][M];
		// 최대 높이
		int maxHeight = -1;
		// 최소 높이
		int minHeight = 257;

		// 맵 정보를 배열에 저장하고
		// 최대, 최소 높이를 찾는 반복문
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] > maxHeight) {
					maxHeight = map[i][j];
				}

				if (map[i][j] < minHeight) {
					minHeight = map[i][j];
				}
			}
		}

		// 평탄화 시간
		int time = Integer.MAX_VALUE;
		// 평탄화 높이
		int height = 0;

		// 평탄화 높이는 최소 높이부터 최대 높이 사이이므로
		// 최소 높이부터 해당 높이로 평탄화하기 위한 시간을 계산해보고
		// 최소 시간 및 최대 높이를 구하는 반복문
		for (int h = minHeight; h <= maxHeight; h++) {

			// 해당 높이의 평탄화 시간
			int tempTime = 0;
			// 인벤토리 용량
			int inventory = B;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					// 높이를 낮추는 경우
					if (map[i][j] > h) {
						tempTime += (map[i][j] - h) * 2;
						inventory += map[i][j] - h;
					} else if (map[i][j] < h) {
						// 높이를 높이는 경우
						inventory -= h - map[i][j];
						tempTime += h - map[i][j];
					}
				}
			}

			// 해당 높이로 평탄화가 가능하려면
			// 작업 종료 후에 인벤토리의 남은 블록이 음수면 안됨
			// 평탄화 시간이 동일하면 더 높은 시간을 반환해야 하므로
			// 평탄화 시간이 동일해도 해당 시간의 높이가 나중에 또 나오면
			// 해당 높이로 최신화해야 함
			if (inventory >= 0 && tempTime <= time) {
				height = h;
				time = tempTime;
			}
		}

		// 결과 출력
		sb.append(time).append(" ").append(height);

		System.out.println(sb);

	}

}
