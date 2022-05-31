package level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2206 {

	private static class Tank {
		int x, y, move;
		boolean isShot;

		Tank(int x, int y, int move, boolean isShot) {
			this.x = x;
			this.y = y;
			this.move = move;
			this.isShot = isShot;
		}
	}

	static int[][] map, isVisited;
	static int minMove, N, M;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 2206. 벽 부수고 이동하기
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);

		map = new int[N][M];
		isVisited = new int[N][M];
		minMove = -1;

		for (int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		bfs();

		System.out.println(minMove);

	}

	private static void bfs() {

		Queue<Tank> bfsQue = new LinkedList<>();

		bfsQue.add(new Tank(0, 0, 0, false));

		while (!bfsQue.isEmpty()) {
			Tank tank = bfsQue.poll();
			tank.move++;
			isVisited[tank.x][tank.y] = 1;

			if (tank.x == N - 1 && tank.y == M - 1) {
				if (tank.move < minMove || minMove == -1)
					minMove = tank.move;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int newX = tank.x + dr[i];
				int newY = tank.y + dc[i];

				if (newX < 0 || newY < 0 || newX >= N || newY >= M)
					continue;
				if (isVisited[newX][newY] == 1)
					continue;
				if (map[newX][newY] == 1 && tank.isShot)
					continue;

				if (map[newX][newY] == 0)
					bfsQue.add(new Tank(newX, newY, tank.move, tank.isShot));
				else
					bfsQue.add(new Tank(newX, newY, tank.move, true));
			}
		}

	}

}
