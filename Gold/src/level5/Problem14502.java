package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14502 {

	static class Virus {
		int x, y;

		Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] space;
	static int N, M, maxVal;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 14502. 연구소
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		space = new int[N][M];
		maxVal = 0;

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				space[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 정보 입력 완료

		dfs(0); // 벽 세우기

		System.out.println(maxVal);

	}

	private static void dfs(int count) {
		// 경계
		if (count == 3) {
			bfs(); // 바이러스 전염 관찰
			return;
		}

		// 재귀
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (space[r][c] == 0) {
					space[r][c] = 1;
					dfs(count + 1);
					space[r][c] = 0;
				}
			}
		}
	}

	private static void bfs() {
		Queue<Virus> bfsQue = new LinkedList<>();
		
		int[][] virusArr = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				virusArr[r][c] = space[r][c];
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (space[r][c] == 2)
					bfsQue.add(new Virus(r, c));
			}
		} // 초기 바이러스 입력

		while (!bfsQue.isEmpty()) {
			Virus next = bfsQue.poll();

			for (int i = 0; i < 4; i++) {
				int newX = next.x + dr[i];
				int newY = next.y + dc[i];

				if (newX < 0 || newY < 0 || newX >= N || newY >= M)
					continue;

				if (virusArr[newX][newY] == 0) {
					virusArr[newX][newY] = 2;
					bfsQue.add(new Virus(newX, newY));
				}
			}
		}

		cal(virusArr);
	}

	private static void cal(int[][] virusArr) {
		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (virusArr[r][c] == 0)
					count++;
			}
		}

		if (count > maxVal)
			maxVal = count;
	}

}
