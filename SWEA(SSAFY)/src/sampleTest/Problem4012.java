package sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4012 {

	static int[][] food;
	static boolean[] isSelected;
	static int N, minVal;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st;

			minVal = Integer.MAX_VALUE; // 최솟값

			N = Integer.parseInt(br.readLine()); // 재료수

			food = new int[N][N]; // 식재료 정보
			isSelected = new boolean[N]; // 선택 여부 배열

			// 식재료 정보 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 조합(A 음식)
			combination(0, 0);
			// 결과 문자열
			sb.append("#").append(test).append(" ").append(minVal).append('\n');
		}

		// 결과 출력
		System.out.println(sb);
	}

	// 조합
	private static void combination(int count, int start) {
		// 경계
		// 음식을 모두 고르면 종료
		if (count == N / 2) {
			// 음식 차이 확인
			check();
			return;
		}

		// 조합
		for (int i = start; i < N; i++) {
			isSelected[i] = true;
			combination(count + 1, i + 1);
			isSelected[i] = false;
		}
	}

	// 음식 맛 차이 확인
	private static void check() {
		int A = 0; // A 맛
		int B = 0; // B 맛
		int diff = 0; // 차이

		// 선택 여부에 맞춰 각 음식별 맛 점수 계산
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (isSelected[i] && isSelected[j]) {
					A += food[i][j] + food[j][i];
				} else if (!isSelected[i] && !isSelected[j]) {
					B += food[i][j] + food[j][i];
				}
			}
		}

		// 맛 차이 계산
		diff = Math.abs(A - B);

		// 최소 맛 차이 최신화
		minVal = diff < minVal ? diff : minVal;
	}

}
