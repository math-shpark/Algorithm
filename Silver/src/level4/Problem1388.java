package level4;

import java.util.Scanner;

public class Problem1388 {

	static int N, M; // 변수
	static char[][] room; // 방 구조
	static boolean[][] isChecked; // 장판 확인 여부
	static int[] dr = { 0, 1 }; // 우, 하
	static int[] dc = { 1, 0 }; // 우, 하

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt(); // 세로
		M = scan.nextInt(); // 가로

		room = new char[N][M]; // 방
		isChecked = new boolean[N][M]; // 장판 확인 여부

		scan.nextLine();

		for (int i = 0; i < N; i++) {
			room[i] = scan.nextLine().toCharArray();
		} // 방 정보

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (isChecked[i][j])
					continue;
				int dir = room[i][j] == '-' ? 0 : 1;
				result++;
				dfs(i, j, dir);
			}
		} // dfs

		System.out.println(result);

	}

	// dfs
	private static void dfs(int i, int j, int dir) {
		isChecked[i][j] = true;

		char need = dir == 0 ? '-' : '|';
		int newX = i + dr[dir];
		int newY = j + dc[dir];

		if (newX < 0 || newX >= N || newY < 0 || newY >= M)
			return;

		if (isChecked[newX][newY])
			return;

		if (room[newX][newY] == need)
			dfs(newX, newY, dir);
	}

}
