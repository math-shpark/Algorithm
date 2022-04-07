package sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2115 {

	// 벌통 크기
	static int N;
	// 벌통 개수
	static int M;
	// 최대 용량
	static int C;
	// 최대 수익
	static int maxVal;
	// 일꾼 1, 2의 최대 수익
	static int income1, income2;
	// 벌통 정보
	static int[][] space;
	// 벌통 선택 여부를 저장할 배열
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			// 배열 크기 입력
			space = new int[N][N];
			isSelected = new boolean[M];
			// 최대 수익 초기화
			maxVal = 0;

			// 벌통 정보 저장
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					space[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 수익 초기화
			income1 = 0;
			income2 = 0;

			// 작업
			process();

			// 결과 문자열
			sb.append("#").append(test).append(" ").append(maxVal).append('\n');
		}

		// 결과 출력
		System.out.println(sb);
	}

	private static void process() {

		// 채취 여부를 저장할 배열
		boolean[][] check = new boolean[N][N];

		// 일꾼 2가 선택한 위치에서 출발 가능한지 여부를 저장할 변수
		boolean isOkay;
		// 일꾼 1의 벌통 위치 찾기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - (M - 1); j++) {
				// 일꾼 1 채취 여부 표시
				// 가로 방향으로만 채취하므로 행 번호 고정
				for (int k = j; k < j + M; k++) {
					check[i][k] = true;
				}

				// 일꾼 2 벌통 위치 찾기
				for (int a = 0; a < N; a++) {
					for (int b = 0; b < N - (M - 1); b++) {
						// 가능 여부 초기화
						isOkay = true;
						// 선택한 점에서 출발해서 M개의 칸을 탐색하며
						for (int c = 0; c < M; c++) {
							// 한 칸이라도 겹치면
							if (check[a][b + c]) {
								// 불가 표시하고
								isOkay = false;
								// 반복 종료
								break;
							}
						}
						// 불가하면
						if (!isOkay) {
							// 해당 위치에서는 출발 불가
							continue;
						}

						// 선택한 일꾼 1과 2의 출발점으로 수익을 계산하는 메서드 실행
						calculate(i, j, a, b, 0);

						// 최대 수익으로 초기화
						if (income1 + income2 > maxVal) {
							maxVal = income1 + income2;
						}

						// 수익 초기화
						income1 = 0;
						income2 = 0;
					}
				}

				// 일꾼 1의 작업 기록 복구
				for (int k = j; k < j + M; k++) {
					check[i][k] = false;
				}
			}
		}
	}

	// 수익 계산
	// 매개 변수 : 일꾼 1의 출발 좌표, 일꾼 2의 출발 좌표, 선택한 통의 개수
	private static void calculate(int i, int j, int a, int b, int depth) {
		// 경계
		// M개의 통을 모두 선택하였으면
		if (depth == M) {

			// 일꾼 1의 누적 꿀
			int count1 = 0;
			// 일꾼 2의 누적 꿀
			int count2 = 0;
			// 일꾼 1의 누적 수익
			int val1 = 0;
			// 일꾼 2의 누적 수익
			int val2 = 0;

			// 선택한 통으로 얻어진 수익을 계산한 후
			for (int k = 0; k < M; k++) {
				if (isSelected[k]) {
					count1 += space[i][j + k];
					val1 += space[i][j + k] * space[i][j + k];

					count2 += space[a][b + k];
					val2 += space[a][b + k] * space[a][b + k];
				}
			}

			// 최대 용량을 넘기지 않았으면 최댓값으로 최신화
			if (count1 <= C) {
				income1 = Math.max(income1, val1);
			}
			if (count2 <= C) {
				income2 = Math.max(income2, val2);
			}
			return;
		}

		// 재귀
		// 조합
		isSelected[depth] = true;
		calculate(i, j, a, b, depth + 1);
		isSelected[depth] = false;
		calculate(i, j, a, b, depth + 1);
	}

}
