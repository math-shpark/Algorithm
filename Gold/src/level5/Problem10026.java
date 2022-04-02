package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10026 {

	// 공간 배열
	static char[][] space;
	// 탐색 여부 저장 배열
	static boolean[][] isVisited;
	// 배열 크기
	static int N;
	// 델타 탐색
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 10026. 적록색약
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// N 입력
		N = Integer.parseInt(br.readLine());
		// 공간 배열 크기 입력
		space = new char[N][N];

		// 공간 정보 입력
		for (int row = 0; row < N; row++) {
			String rowStr = br.readLine();

			for (int col = 0; col < N; col++) {
				space[row][col] = rowStr.charAt(col);
			}
		}

		// 탐색 여부 저장 배열 초기화
		isVisited = new boolean[N][N];
		// 적록색약이 아닌 사람이 볼 때 구역의 수
		int countArea1 = 0;

		// 적록색약이 아닌 사람의 dfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 탐색 전인 칸이 있으면
				if (isVisited[i][j] == false) {
					// 해당 칸을 시작으로 dfs 탐색을 시작한 후
					dfs(i, j);
					// 구역 개수 1 추가
					countArea1++;
				}
			}
		}

		// 결과 문자열 입력
		sb.append(countArea1).append(" ");

		// 탐색 여부 저장 배열 초기화
		isVisited = new boolean[N][N];
		// 적록색약인 사람일 볼 때의 공간 정보로 변경
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (space[i][j] == 'G') {
					space[i][j] = 'R';
				}
			}
		}
		// 적록색약인 사람이 볼 때 구역의 수
		int countArea2 = 0;

		// 적록색약인 사람의 dfs
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (isVisited[i][j] == false) {
					dfs(i, j);
					countArea2++;
				}
			}
		}

		// 결과 문자열 입력
		sb.append(countArea2);

		// 결과 출력
		System.out.println(sb);
	}

	// dfs
	private static void dfs(int startX, int startY) {

		// 시작 위치의 색 저장
		char color = space[startX][startY];
		// 시작 위치 탐색 여부 표시
		isVisited[startX][startY] = true;

		// 델타 탐색을 한 후
		for (int i = 0; i < 4; i++) {
			int newX = startX + dr[i];
			int newY = startY + dc[i];

			// 이동 가능 칸이면서
			if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
				// 아직 탐색하지 않았고
				// 시작 위치의 색과 동일하면 재귀 호출
				if (isVisited[newX][newY] == false && space[newX][newY] == color) {
					dfs(newX, newY);
				}
			}
		}

	}

}
