package sampleTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem4013 {

	// 자성 정보 배열
	static int[][] magnetic;

	// 4013. 특이한 자석
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			// 자석 회전 횟수
			int K = Integer.parseInt(br.readLine());

			// 자석 배열
			magnetic = new int[4][8];

			// 자성 정보 입력
			StringTokenizer st;
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					magnetic[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 자성 정보 입력 완료

			// 자석 회전
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				// 회전할 자석 번호
				int magneticNum = Integer.parseInt(st.nextToken()) - 1;
				// 회전 방향
				int direction = Integer.parseInt(st.nextToken());

				// 자석별 회전 여부 초기화
				boolean[] isRotate = new boolean[4];

				// 회전할 자석은 회전 여부 표기
				isRotate[magneticNum] = true;

				// 회전 여부를 판별할 때 사용할 큐
				Queue<Integer> que = new LinkedList<Integer>();

				// 회전 자석 추가
				que.add(magneticNum);

				// 회전할 자석을 시작으로 양 옆으로 이동하며 회전 여부 판단
				while (!que.isEmpty()) {
					// 기준 자석
					int front = que.poll();

					// 1. 회전 대상 자석의 왼쪽에도 자석이 있는 경우
					if (front - 1 >= 0) {
						// 왼쪽 자석의 2번 인덱스와 회전 자석의 6번 인덱스 값이 다르면 회전
						if (!isRotate[front - 1] && magnetic[front][6] != magnetic[front - 1][2]) {
							isRotate[front - 1] = true;
							que.add(front - 1);
						}
					}

					// 2. 회전 자석의 오른쪽에도 자석이 있는 경우
					if (front + 1 < 4) {
						// 오른쪽 자석의 6번 인덱스와 회전 자석의 2번 인덱스 값이 다르면 회전
						if (!isRotate[front + 1] && magnetic[front][2] != magnetic[front + 1][6]) {
							isRotate[front + 1] = true;
							que.add(front + 1);
						}
					}
				} // 회전 여부 판별 완료

				// 회전 여부에 맞춰 회전
				for (int j = 0; j < 4; j++) {
					// 회전해야 하는 자석이면
					if (isRotate[j]) {
						// 회전 자석으로 지목되거나 인덱스 차이가 2인 자석이 지목된 경우 방향 유지
						if (magneticNum == j || magneticNum == (j - 2) || magneticNum == (j + 2)) {
							rotation(j, direction);
						} else {
							// 아니면 반대 방향으로 회전
							rotation(j, -direction);
						}
					}
				} // 1회 회전 완료

			} // 전체 회전 완료

			// 총 점수
			int total = 0;
			for (int i = 0; i < 4; i++) {
				// 0번 인덱스에 s극인 경우만 점수 합산
				total += (magnetic[i][0] == 1 ? Math.pow(2, i) : 0);
			} // 점수 계산 완료

			// 결과 문자열 생성
			sb.append("#").append(test).append(" ").append(total).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

	// 회전 메서드
	private static void rotation(int magneticNum, int direction) {

		// 회전하기 전 값 복사
		int[] temp = new int[8];
		for (int i = 0; i < 8; i++) {
			temp[i] = magnetic[magneticNum][i];
		}

		// 회전 방향에 맞춰 회전
		switch (direction) {
		// 시계 방향
		case 1:
			for (int i = 1; i < 8; i++) {
				magnetic[magneticNum][i] = temp[i - 1];
			}
			magnetic[magneticNum][0] = temp[7];
			break;
		// 반시계 방향
		case -1:
			for (int i = 0; i < 7; i++) {
				magnetic[magneticNum][i] = temp[i + 1];
			}
			magnetic[magneticNum][7] = temp[0];
			break;
		}

	}

}
