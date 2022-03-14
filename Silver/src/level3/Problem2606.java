package level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2606 {

	// 연결 정보를 저장할 배열
	static int[][] space;
	// 탐색 여부를 저장할 배열
	static boolean[] isVisited;
	// 연결된 컴퓨터의 개수를 저장할 변수
	static int count;

	// 2606. 바이러스
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 컴퓨터의 개수
		int computer = Integer.parseInt(br.readLine());
		// 연결된 쌍의 개수
		int pair = Integer.parseInt(br.readLine());
		// 연결 정보를 저장할 배열 크기 지정
		space = new int[computer + 1][computer + 1];
		// 탐색 정보를 저장할 배열 크기 지정
		isVisited = new boolean[computer + 1];

		// 연결 정보를 저장하는 반복문
		for (int i = 0; i < pair; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			space[first][second] = 1;
			space[second][first] = 1;
		}

		// 1번 컴퓨터를 시작으로 dfs 탐색 시작
		dfs(1);

		// 결과 출력
		System.out.println(count);

	}

	private static void dfs(int computer) {

		// 현재 컴퓨터는 탐색했음을 표시
		isVisited[computer] = true;

		// 다음 탐색할 컴퓨터를 찾아서
		// 아직 탐색하지 않은 컴퓨터가 있으면 재귀실행
		for (int i = 0; i < space.length; i++) {
			if (space[computer][i] == 1 && isVisited[i] == false) {
				count++;
				dfs(i);
			}
		}

	}

}
