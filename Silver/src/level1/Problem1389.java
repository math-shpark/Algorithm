package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1389 {

	// 연결 정보 저장
	static int[][] space;
	// 방문 정보 저장
	static boolean[] isVisited;

	// 1389. 케빈 베이컨의 6단계의 법칙
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 노드 개수
		int N = Integer.parseInt(st.nextToken());
		// 간선 개수
		int M = Integer.parseInt(st.nextToken());

		// 연결 정보 배열 크기 지정
		space = new int[N + 1][N + 1];

		// 연결 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());

			space[num1][num2] = 1;
			space[num2][num1] = 1;
		}

		// 노드별 케빈 베이컨의 수를 저장할 배열
		int[][] stageArr = new int[N + 1][2];

		// 각 노드를 출발점으로 하여
		// bfs 탐색 결과를 stageArr에 저장
		for (int i = 1; i <= N; i++) {
			isVisited = new boolean[N + 1];
			stageArr[i][0] = i;
			stageArr[i][1] = bfs(i);
		}

		// 제시된 조건에 맞춰 정렬
		Arrays.sort(stageArr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		// 결과 출력
		System.out.println(stageArr[1][0]);

	}

	// bfs
	private static int bfs(int startNode) {
		// 큐 생성
		Queue<Integer> bfsQue = new LinkedList<Integer>();
		// 시작 노드 추가
		bfsQue.add(startNode);
		// 시작 노드 탐색 표시
		isVisited[startNode] = true;

		// 연결된 노드별 거리를 저장할 배열
		int[] stage = new int[space.length];
		// 거리
		int count = 1;
		// 베이컨의 수
		int sum = 0;

		while (!bfsQue.isEmpty()) {

			// 동일한 거리의 노드 개수
			int range = bfsQue.size();

			// 동일한 거리의 노드 개수만큼 반복
			for (int c = 0; c < range; c++) {
				int temp = bfsQue.poll();
				for (int i = 1; i < space.length; i++) {
					if (space[temp][i] == 1 && isVisited[i] == false) {
						bfsQue.add(i);
						stage[i] = count;
						isVisited[i] = true;
					}
				}
			}

			// 거리 증가
			count++;
		}

		// 베이컨의 수를 구하는 반복문
		for (int i = 1; i < space.length; i++) {
			sum += stage[i];
		}

		return sum;

	}

}
