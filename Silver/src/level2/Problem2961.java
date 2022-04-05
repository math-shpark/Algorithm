package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2961 {

	// 신맛 배열
	static int[] taste1;
	// 쓴맛 배열
	static int[] taste2;
	// 선택한 재료 배열
	static int[] material;
	// 재료의 개수
	static int N;
	// 맛의 차이
	static int minDiff = Integer.MAX_VALUE;

	// 2961. 도영이가 만든 맛있는 음식
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 재료 개수
		N = Integer.parseInt(br.readLine());

		// 배열 크기 입력
		taste1 = new int[N];
		taste2 = new int[N];

		// 배열에 데이터 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());

			taste1[i] = t1;
			taste2[i] = t2;
		}

		// 재료 개수별 조합 실행
		for (int i = 1; i <= N; i++) {
			material = new int[i];
			combination(i, 0, 0);
		}

		// 결과 출력
		System.out.println(minDiff);

	}

	// 조합
	private static void combination(int max, int start, int count) {
		// 경계
		// 뽑은 재료의 개수가 원하는 재료의 개수면 재귀 종료
		if (count == max) {
			// 신맛
			int t1 = 1;
			// 쓴맛
			int t2 = 0;

			// 선택한 재료의 인덱스에 해당하는 맛의 점수 계산
			for (int idx : material) {
				t1 *= taste1[idx];
				t2 += taste2[idx];
			}

			// 해당 재료로 만든 음식의 점수 차이가 더 작으면 변경
			if (minDiff > Math.abs(t1 - t2)) {
				minDiff = Math.abs(t1 - t2);
			}
			return;
		}

		// 재귀
		for (int i = start; i < N; i++) {
			material[count] = i;
			combination(max, i + 1, count + 1);
		}

	}

}
