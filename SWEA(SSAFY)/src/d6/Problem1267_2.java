package d6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem1267_2 {

	static int V; // 정점 수
	static List<Integer>[] adjList; // 인접 리스트
	static int[] inDegree; // 진입 차수 배열
	static StringBuilder sb = new StringBuilder(); // 문자열 생성
	static Stack<Integer> ans; // 완료한 작업들을 저장할 스택
	static boolean[] isVisited; // 탐색 여부 저장 배열

	// 1267. 작업순서(Stack)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test = 1; test <= 10; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken()); // 정점 수
			int E = Integer.parseInt(st.nextToken()); // 간선 수

			adjList = new ArrayList[V + 1]; // 인접 리스트 크기 입력
			inDegree = new int[V + 1]; // 진입 차수 배열 크기 입력
			ans = new Stack<>(); // 정답 스택
			isVisited = new boolean[V + 1];

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

			// 진입 차수가 0인 정점마다 DFS 실행
			for (int i = 1; i <= V; i++) {
				if (inDegree[i] == 0)
					topologicalSort(i);
			}

			// 위의 반복문이 종료되면 작업 순서에 맞춰 정답 스택에 완료된 작업들이 쌓여있는 상태이다.
			// 스택에서 하나씩 꺼내 결과 문자열을 생성한다.
			while (!ans.isEmpty()) {
				sb.append(ans.pop()).append(" ");
			}

			// 테스트 케이스가 종료되었으므로 줄바꿈
			sb.append('\n');

		}
		// 결과 출력
		System.out.println(sb);
	}

	// 위상정렬(Queue 사용)
	private static void topologicalSort(int node) {

		// 1. 현재 정점은 탐색했음을 표시한다.
		isVisited[node] = true;

		// 2. 현재 정점과 연결된 정점 중 방문하지 않은 정점이 있으면 재귀 호출한다.
		for (int nextNode : adjList[node]) {
			if (isVisited[nextNode])
				continue;
			topologicalSort(nextNode);
		}
		// 위의 반복문이 종료되었다는 것은 현재 노드 이후 작업들이 모두 처리되어 정답 스택에 추가된 것
		// 3. 이제는 현재 노드를 정답 스택에 추가한다.
		ans.push(node);
	}

}
