package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1227 {

	// 미로 공간
	static int[][] space;
	// 방문 여부 저장 배열
	static boolean[][] isVisited;
	// 도착 가능 여부 저장 변수
	static boolean isPossible;
	// 델타 탐색
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 1227. 미로 2
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 10번의 테스트 케이스 반복
		for (int test = 1; test <= 10; test++) {
			int testNum = Integer.parseInt(br.readLine());

			// 미로 공간 초기화
			space = new int[100][100];
			// 방문 여부 배열 초기화
			isVisited = new boolean[100][100];
			// 탐색 가능 여부 초기화
			isPossible = false;

			// 출발점 좌표
			int startX = 0;
			int startY = 0;

			// 미로 공간 정보 입력
			for (int i = 0; i < 100; i++) {
				String str = br.readLine();

				for (int j = 0; j < 100; j++) {
					space[i][j] = str.charAt(j) - '0';

					// 출발점 좌표 저장
					if (space[i][j] == 2) {
						startX = i;
						startY = j;
					}
				}
			}

			// dfs 탐색
			dfs(startX, startY);

			// 출력 양식
			sb.append("#").append(testNum).append(" ");

			// 가능 여부에 맞춰 문자열 생성
			if (isPossible) {
				sb.append(1);
			} else {
				sb.append(0);
			}

			sb.append('\n');

		}

		// 결과 출력
		System.out.println(sb);

	}

	// dfs 탐색
	private static void dfs(int startX, int startY) {

		// 탐색 출발점 방문 여부 표시
		isVisited[startX][startY] = true;

		// 델타 탐색 후 이동 가능한 지점 재귀
		for (int i = 0; i < 4; i++) {
			int newX = startX + dr[i];
			int newY = startY + dc[i];

			// 이동 가능하고 아직 탐색 전이면 이동
			if (space[newX][newY] == 0 && isVisited[newX][newY] == false) {
				dfs(newX, newY);
			} else if (space[newX][newY] == 3) {
				// 이동 가능 범위의 지점이 도착점이면
				// 가능 여부를 표시하고 메서드 종료
				isPossible = true;
				return;
			}
		}

	}

}
