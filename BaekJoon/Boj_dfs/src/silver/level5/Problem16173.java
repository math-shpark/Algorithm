package silver.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16173 {

	private static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	// 16173. 점프왕 쩰리
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		boolean[][] isVisited = new boolean[N][N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Node> bfsQue = new LinkedList<>();
		bfsQue.add(new Node(0, 0));

		int[] dr = { 0, 1 };
		int[] dc = { 1, 0 };

		while (!bfsQue.isEmpty()) {
			Node now = bfsQue.poll();

			isVisited[now.x][now.y] = true;

			if (map[now.x][now.y] == -1) {
				System.out.println("HaruHaru");
				return;
			}

			for (int i = 0; i < 2; i++) {
				int newX = now.x + dr[i] * map[now.x][now.y];
				int newY = now.y + dc[i] * map[now.x][now.y];

				if (newX < 0 || newX >= N || newY < 0 || newY >= N)
					continue;

				if (isVisited[newX][newY])
					continue;

				bfsQue.add(new Node(newX, newY));
			}
		}

		System.out.println("Hing");
	}

}
