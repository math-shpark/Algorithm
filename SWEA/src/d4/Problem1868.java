package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Problem1868 {

	// 공간 정보 배열
	static char[][] space;
	// 지뢰 정보 배열
	static int[][] bombNum;
	// 클릭 여부 저장 배열
	static boolean[][] isClicked;
	// 델타 탐색
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	// 공간 크기
	static int N;

	// 1868. 파핑파핑 지뢰찾기
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		// 입력한 개수만큼 반복
		for (int test = 1; test <= testCase; test++) {
			N = Integer.parseInt(br.readLine());
			// 입력한 크기로 배열 지정
			space = new char[N][N];
			bombNum = new int[N][N];
			isClicked = new boolean[N][N];

			// space 배열에 지뢰 정보 저장
			for (int i = 0; i < N; i++) {
				String str = br.readLine();

				for (int j = 0; j < N; j++) {
					space[i][j] = str.charAt(j);
				}
			} // 폭탄 정보 입력 종료

			// 각 칸의 숫자 정보를 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 지뢰가 담긴 칸일 경우 9를 입력
					if (space[i][j] == '*') {
						bombNum[i][j] = 9;
						continue;
					}
					int count = 0;
					// 델타 탐색을 하여 주변의 지뢰 개수 계산
					for (int k = 0; k < 8; k++) {
						int newX = i + dr[k];
						int newY = j + dc[k];

						// 범위 내로 이동 가능할 때
						if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
							// 폭탄이 있으면 개수에 추가
							if (space[newX][newY] == '*') {
								count++;
							}
						}
					}
					// 위의 반복문에서 찾은 폭탄의 개수 입력
					bombNum[i][j] = count;

				}
			} // 폭탄 개수 입력 종료

			// 클릭 횟수
			int click = 0;
			// 숫자가 0인 곳부터 클릭하기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (bombNum[i][j] == 0 && isClicked[i][j] == false) {
						bfs(i, j);
						click++;
					}
				}
			} // 0인 곳 클릭 완료

			// 아직 눌리지 않은 칸 누르기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (bombNum[i][j] != 9 && isClicked[i][j] == false) {
						click++;
					}
				}
			} // 나머지 칸 누르기 완료

			sb.append("#").append(test).append(" ").append(click).append('\n');
		} // 테스트 케이스 종료

		// 결과 출력
		System.out.println(sb);

	}

	private static void bfs(int startX, int startY) {

		Queue<Node> bfsQue = new LinkedList<>();

		bfsQue.add(new Node(startX, startY));
		isClicked[startX][startY] = true;

		while (!bfsQue.isEmpty()) {
			// 큐에서 시작 노드 하나 꺼내기
			Node front = bfsQue.poll();

			// 8방향 델타 탐색
			for (int i = 0; i < 8; i++) {
				int newX = front.x + dr[i];
				int newY = front.y + dc[i];

				// 범위 내 이동 가능하면서
				if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
					// 지뢰가 아니면 숫자가 보여야 하므로 클릭 여부 표시
					if (bombNum[newX][newY] != 9 && isClicked[newX][newY] == false) {
						isClicked[newX][newY] = true;
						// 지뢰 개수가 0이면 연속적으로 눌려야 하므로 큐에 추가
						if (bombNum[newX][newY] == 0) {
							bfsQue.add(new Node(newX, newY));
						}
					}
				}
			}
		}

	}

}
