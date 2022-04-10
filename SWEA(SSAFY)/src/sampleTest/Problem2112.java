package sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2112 {

	// 필름 두께
	static int D;
	// 필름 가로 길이
	static int W;
	// 검증 기준
	static int K;
	// 필름 속성 정보
	static int[][] film;
	// 최소 횟수
	static int result;

	// 2112. 보호 필름
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 두께, 가로 길이, 검증 기준 입력
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			// 배열 크기 입력
			film = new int[D][W];

			// 최소 횟수 초기화
			result = K;

			// 필름 값 입력
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++)
					film[i][j] = Integer.parseInt(st.nextToken());
			}

			// 맨 윗 줄부터 약품을 넣어보면서
			// 테스트 통과 여부를 확인하는 메서드
			process(0, 0);

			// 결과 문자열
			sb.append("#").append(test).append(" ").append(result).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

	// 약품을 넣는 메서드
	// 매개변수 : 약품을 넣을 행, 약품을 넣은 누적 횟수
	static void process(int row, int count) {

		// 경계 1
		// 현재 필름 상태가 테스트 통과 가능하면
		if (check()) {
			// 최솟값으로 최신화
			if (count < result) {
				result = count;
			}

			// 재귀 종료
			return;
		}

		// 경계 2
		// 이미 넣은 약품 횟수가 최솟값이 아니면 건너뛰기(백트래킹)
		if (count > result) {
			return;
		}

		// 경계 3
		// 마지막 행까지 완료되면 재귀 종료
		if (row == D) {
			return;
		}

		// 선택한 행의 속성값만 복사할 배열 생성
		int[] temp = new int[W];

		// 속성값 복사
		for (int i = 0; i < W; i++) {
			temp[i] = film[row][i];
		}

		// 1. 현재 행을 일단 두고 진행하기
		process(row + 1, count);

		// 2. 현재 행에 A 약품을 넣고 진행하기
		for (int i = 0; i < W; i++) {
			film[row][i] = 0;
		}
		process(row + 1, count + 1);

		// 3. 현재 행에 B 약품을 넣고 진행하기
		for (int i = 0; i < W; i++) {
			film[row][i] = 1;
		}
		process(row + 1, count + 1);

		// 원상복귀
		for (int i = 0; i < W; i++) {
			film[row][i] = temp[i];
		}
	}

	// 테스트 통과 여부를 확인하는 메서드
	public static boolean check() {

		for (int j = 0; j < W; j++) {
			// 현재 열 안에서 누적 연속 속성 개수
			int count = 1;
			// 테스트 통과 여부
			boolean isOkay = false;

			for (int i = 1; i < D; i++) {
				// 이전 행과 지금 행이 같은 속성일 경우
				if (film[i][j] == film[i - 1][j]) {
					// 누적 횟수 + 1
					count++;
				} else {
					// 다르면 누적 횟수 초기화
					count = 1;
				}

				// 누적 횟수가 이미 통과면
				if (count == K) {
					// 통과 여부를 표시하고
					isOkay = true;
					// 현재 열 탐색 종료
					break;
				}
			}

			// 마지막 행까지 탐색했는데 여전히 통과를 못했으면
			if (!isOkay) {
				// 불합격임을 반환
				return false;
			}
		}

		// 모든 열을 탐색하였는데 반환이 안된 것은
		// 모든 열이 기준을 통과했다는 것
		return true;
	}

}
