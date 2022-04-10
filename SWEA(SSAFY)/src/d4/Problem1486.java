package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1486 {

	// 직원 키 정보
	static int[] height;
	// 직원 수
	static int N;
	// 선택한 직원의 키
	static int[] selected;
	// 선반 높이
	static int B;
	// 최소 높이
	static int minHeight;

	// 1486. 장훈이의 높은 선반
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			// 직원 수
			N = Integer.parseInt(st.nextToken());
			// 선반 높이
			B = Integer.parseInt(st.nextToken());

			// 직원 키 정보
			height = new int[N];

			// 최소 높이 정보 초기화
			minHeight = 0;

			// 키 정보 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				height[i] = Integer.parseInt(st.nextToken());
				minHeight += height[i];
			}

			// 1명부터 N명까지 조합을 진행
			for (int i = 1; i <= N; i++) {
				selected = new int[i];
				combination(0, 0, i);
			}

			// 결과 문자열 생성
			sb.append("#").append(test).append(" ").append(minHeight - B).append('\n');

		}

		// 결과 출력
		System.out.println(sb);

	}

	// 조합
	// 매개변수 : 선택 시작 인덱스, 현재까지 뽑은 직원 수, 뽑을 수 있는 직원 수
	private static void combination(int start, int count, int maximum) {

		// 경계
		if (count == maximum) {
			// 직원을 다 뽑았으면
			// 뽑은 직원들의 키를 더한 후
			int sum = 0;
			for (int num : selected) {
				sum += num;
			}

			// 더한 높이가 선반 높이보다 크거나 같으면
			if (sum >= B) {
				// 지금 최소 높이로 저장된 높이와 비교
				if (sum < minHeight) {
					// 더 작은 값으로 최신화
					minHeight = sum;
				}
			}

			// 재귀 종료
			return;
		}

		// 재귀
		for (int i = start; i < N; i++) {
			selected[count] = height[i];
			combination(i + 1, count + 1, maximum);
		}

	}

}
