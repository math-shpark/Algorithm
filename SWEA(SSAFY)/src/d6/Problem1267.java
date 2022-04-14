package d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1267 {

	static int V; // 정점 수
	static List<Integer>[] adjList; // 인접 리스트
	static int[] inDegree; // 진입 차수 배열
	static StringBuilder sb = new StringBuilder(); // 문자열 생성

	// 1267. 작업순서(Queue)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken()); // 정점 수
			int E = Integer.parseInt(st.nextToken()); // 간선 수

			adjList = new ArrayList[V + 1]; // 인접 리스트 크기 입력
			inDegree = new int[V + 1]; // 진입 차수 배열 크기 입력

			// 정점별 리스트 객체 생성
			for (int v = 1; v <= V; v++) {
				adjList[v] = new ArrayList<>();
			} // 정점별 리스트 객체 생성 완료

			// 간선 연결 정보 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				// 1. 연결 정보 입력
				adjList[start].add(end);
				// 2. 도착 정점 진입 차수 반영
				inDegree[end]++;
			} // 간선 정보 입력 완료

			sb.append("#").append(test).append(" "); // 출력 양식

			// 위상정렬 메서드 실행
			topologicalSort();

			// 1개의 테스트 케이스가 종료되었으므로 줄바꿈
			sb.append('\n');
		}
		// 결과 출력
		System.out.println(sb);
	}

	// 위상정렬(Queue 사용)
	private static void topologicalSort() {
		Queue<Integer> que = new LinkedList<>();

		// 1. 진입 차수가 0인 정점들을 큐에 추가한다.
		for (int i = 1; i <= V; i++) {
			if (inDegree[i] == 0)
				que.add(i);
		}

		// 큐에 정점이 전부 없어질 때까지 반복한다.
		while (!que.isEmpty()) {
			// 2 - 1. 큐에서 정점을 하나씩 꺼내며 해당 정점과 연결된 간선들을 제거한다.
			int node = que.poll();
			for (int i = 0; i < adjList[node].size(); i++) {
				int nextNode = adjList[node].get(i);
				inDegree[nextNode]--;
				// 2-2. 간선을 제거했을 때 도착 정점의 진입 차수가 0이 되면 큐에 추가한다.
				if (inDegree[nextNode] == 0)
					que.add(nextNode);
			}
			// 3. 큐에서 꺼낸 정점은 결과 문자열에 연결한다.
			sb.append(node).append(" ");
		}
	}

}
