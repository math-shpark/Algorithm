package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1260 {
	// 노드 간 연결 정보를 저장할 배열
	static int[][] space;
	// 해당 노드를 방문했는지 여부를 저장할 배열
	static boolean[] isVisited;
	// 출력 문자열
	static StringBuilder sb = new StringBuilder();

	// 1260. DFS와 BFS
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 노드
		int node = Integer.parseInt(st.nextToken());
		// 간선
		int edge = Integer.parseInt(st.nextToken());
		// 시작 노드
		int startNode = Integer.parseInt(st.nextToken());

		// 노드 번호를 인덱스로 취하기 때문에 노드보다 1 큰 크기의 배열 생성
		space = new int[node + 1][node + 1];

		// 연결 정보를 space 배열에 저장하는 반복문
		for (int i = 0; i < edge; i++) {
			// 한 줄을 읽은 후
			st = new StringTokenizer(br.readLine());
			// 연결할 노드 정보를 변수에 저장한 후
			int firstNode = Integer.parseInt(st.nextToken());
			int secondNode = Integer.parseInt(st.nextToken());

			// 해당 노드를 인덱스로 취해 연결 여부를 1로 저장
			// 초기값이 0이므로 반복문 종료 후 0이 저장된 위치의 인덱스는 연결되지 않은 것으로 확인 가능
			space[firstNode][secondNode] = 1;
			space[secondNode][firstNode] = 1;
		}

		// dfs 실행
		isVisited = new boolean[node + 1];
		dfs(startNode);

		// 줄바꿈
		sb.append('\n');

		// bfs 실행
		isVisited = new boolean[node + 1];
		bfs(startNode);

		// 결과 출력
		System.out.println(sb);

	}

	private static void dfs(int startNode) {

		// 출발 노드 탐색했음 표시
		isVisited[startNode] = true;

		// 출발 노드 출력 문자열에 추가
		sb.append(startNode).append(" ");

		// 기본
		// space의 length는 node + 1이고
		// 탐색 가능한 노드 최대 번호는 node이므로
		// 매개변수로 입력된 노드 번호가 space의 length - 1과 같으면
		// 매개변수로 입력된 노드가 마지막 노드이므로 재귀 종료
		if (startNode == space.length - 1) {
			return;
		}

		// 재귀
		// 마지막 노드가 아니면
		// 현재 노드를 기준으로 연결된 노드 탐색
		// 탐색 가능한 노드가 여러 개이면 작은 번호의 노드로 이동하는 것이 조건이므로
		// 반복문 시작을 0부터 마지막 노드 순으로 탐색 및 재귀
		for (int node = 0; node < space.length; node++) {
			if (space[startNode][node] == 1 && isVisited[node] == false) {
				dfs(node);
			}
		}

	}

	private static void bfs(int startNode) {

		// 동일한 거리 순으로 노드 정보를 저장할 큐 생성
		Queue<Integer> bfsQue = new LinkedList<Integer>();

		// 시작 노드를 큐에 저장
		bfsQue.add(startNode);
		// 시작 노드를 탐색했음을 표시
		isVisited[startNode] = true;

		// 시작 노드 출력
		sb.append(startNode).append(" ");

		// 탐색 가능한 노드가 없을 때까지 반복
		while (!bfsQue.isEmpty()) {
			// 임시 기준 노드
			int tempNode = bfsQue.poll();

			// 탐색 가능한 노드가 여러 개이면 작은 번호부터 탐색하는 조건이 있으므로
			// 반복문 시작을 0부터 마지막 노드 순으로 탐색 및 큐에 해당 노드 추가
			for (int node = 0; node < space.length; node++) {
				// 노드가 연결되어 있고
				// 아직 탐색한 노드가 아니면
				if (space[tempNode][node] == 1 && isVisited[node] == false) {
					// 큐에 저장하고
					bfsQue.add(node);
					// 해당 노드를 탐색했음을 표시
					isVisited[node] = true;
					// 탐색한 노드 출력 문자열에 추가
					sb.append(node).append(" ");
				}
			}

			// 반복문이 종료되면 tempNode를 기준으로 동일한 거리의 노드들이
			// 오름차순으로 큐에 저장됨
			// 그럼 이제 다음 거리의 노드를 기준으로 탐색 과정 반복
			// 제일 마지막 노드에 도달하면 큐에 추가되는 노드가 없으므로 while문은 종료됨
		}

	}

}
