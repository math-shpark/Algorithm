package silver.level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 아파트 노드
class Apt {
	int x;
	int y;

	public Apt(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Problem2667 {

	// 공간 정보 배열
	static int[][] space;
	// 탐색 여부 저장 배열
	static boolean[][] isVisited;
	// 델타 탐색
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	// 배열 크기
	static int N;

	// 2667. 단지 번호 붙이기
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 배열 크기 입력
		N = Integer.parseInt(br.readLine());
		// 배열 크기 지정
		space = new int[N][N];
		isVisited = new boolean[N][N];
		// 단지별 아파트 개수 저장 리스트
		List<Integer> aptList = new ArrayList<>();

		// 배열에 데이터 저장 반복문
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				space[i][j] = str.charAt(j) - '0';
			}
		}

		// 각 노드를 출발 노드로 하여 bfs 탐색 결과를 aptList에 추가
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (space[i][j] == 1 && isVisited[i][j] == false) {
					int apt = bfs(i, j);
					aptList.add(apt);
				}
			}
		}

		// aptList 크기가 단지 개수
		System.out.println(aptList.size());

		// 오름차순 정렬
		Collections.sort(aptList);

		// 단지별 아파트 개수 출력
		for (int aptNum : aptList) {
			System.out.println(aptNum);
		}
	}

	// bfs 탐색
	private static int bfs(int startX, int startY) {

		Queue<Apt> bfsQue = new LinkedList<>();

		Apt startApt = new Apt(startX, startY);

		bfsQue.add(startApt);

		isVisited[startX][startY] = true;
		int count = 1;

		while (!bfsQue.isEmpty()) {
			Apt temp = bfsQue.poll();

			for (int i = 0; i < 4; i++) {
				int newX = temp.x + dr[i];
				int newY = temp.y + dc[i];

				if (newX >= 0 && newX < N && newY >= 0 && newY < N) {
					if (space[newX][newY] == 1 && isVisited[newX][newY] == false) {
						Apt nextApt = new Apt(newX, newY);
						bfsQue.add(nextApt);
						isVisited[newX][newY] = true;
						count++;
					}
				}
			}
		}

		return count;

	}

}
