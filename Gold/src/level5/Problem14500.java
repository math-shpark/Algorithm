package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14500 {

	// 높이
	static int N;
	// 너비
	static int M;
	// 공간 정보
	static int[][] space;
	// 탐색 여부 저장 배열
	static boolean[][] isVisited;
	// 델타 탐색
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 최대 합
	static int maxSum;

	// 14500. 테트로미노
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 크기 입력
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		// 크기에 맞춰 배열 생성
		space = new int[N][M];
		isVisited = new boolean[N][M];
		// 최대 합 초기화
		maxSum = 0;

		// 배열에 공간 정보 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 한 칸씩 델타 탐색 메소드 실행
		// 단, ㅓ 모양 테트로미노만 별도 메소드로 실행
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				search(i, j, 1, space[i][j]);
				search2(i, j);
			}
		}
		// 결과 출력
		System.out.println(maxSum);

	}

	// ㅓ모양 제외 테트로미노 내 값을 더하는 메소드
	// 재귀 함수
	public static void search(int x, int y, int index, int sum) {

		// 기본
		// 4번째 탐색 칸이면 반환
		if (index == 4) {
			if (sum > maxSum) {
				maxSum = sum;
			}
			return;
		}

		// 재귀
		// 현재 칸은 탐색한 것이므로 true로 표시
		isVisited[x][y] = true;

		// 현재 칸 기준 델타 탐색을 진행하고
		for (int i = 0; i < 4; i++) {
			int newX = x + dr[i];
			int newY = y + dc[i];

			// 다음 칸이 범위 내면서 아직 탐색하지 않은 칸이면
			if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
				if (isVisited[newX][newY] == false) {
					// 해당 칸으로 기준을 변경한 후 다시 탐색 메소드 실행(재귀)
					search(newX, newY, index + 1, sum + space[newX][newY]);
				}
			}
		}

		// 다음 칸에서 현재 칸을 다시 탐색해야 할 수 있으므로 false로 다시 초기화
		isVisited[x][y] = false;

	}

	// ㅓ 모양 테트로미노 내 값을 더하는 메소드
	public static void search2(int x, int y) {

		// 현재 칸을 기준으로 상하좌우 방향 값을 저장할 배열
		int[] dirValue = new int[4];
		// 현재 칸 기준 상하좌우 방향 데이터 중 최소값
		int minValue = Integer.MAX_VALUE;
		// 현재 칸 기준 상하좌우 방향으로 탐색 가능한 칸의 개수
		int countDir = 4;
		// 테트로미노 내 값들의 합
		int sum = space[x][y];

		// 상하좌우로 델타 탐색을 진행하고
		for (int i = 0; i < 4; i++) {
			int newX = x + dr[i];
			int newY = y + dc[i];
			if (newX >= 0 && newX < N && newY >= 0 && newY < M) {
				// 해당 데이터가 최소값인지 판별하고
				if (space[newX][newY] < minValue) {
					minValue = space[newX][newY];
				}
				// 해당 데이터를 배열에 저장
				dirValue[i] = space[newX][newY];
			} else {
				// 해당 방향으로 탐색이 불가하면
				// 탐색 가능 칸의 개수에서 1 차감
				countDir--;
				// 차감한 결과가 3개보다 작으면 ㅓ모양으로 만들 수 없으므로 메소드 종료
				if (countDir < 3) {
					return;
				}
			}
		}

		// 탐색 가능 칸이 3개 이상이면
		if (countDir >= 3) {
			// 우선 배열에 저장된 값을 모두 더하고
			for (int i = 0; i < 4; i++) {
				sum += dirValue[i];
			}
			// 상하좌우 모두 탐색 가능한 경우
			// 최솟값을 뺌
			if (countDir == 4) {
				sum -= minValue;
			}
		}

		// 최대합인지 여부 판단
		if (sum > maxSum) {
			maxSum = sum;
		}

	}

}
