package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem5249_2 {

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// 오름차순 정렬(가중치 기준)
			return this.weight - o.weight;
		}

	}

	// 5249. 최소 신장 트리 (PRIM)
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 마지막 정점 번호
			int V = Integer.parseInt(st.nextToken());
			// 간선 수
			int E = Integer.parseInt(st.nextToken());

			// 인접 리스트
			List<Edge>[] adjList = new ArrayList[V + 1];

			// 각 인덱스별 초기 리스트 객체 생성
			for (int i = 0; i <= V; i++) {
				adjList[i] = new ArrayList<>();
			}

			// 간선 정보 입력
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				adjList[start].add(new Edge(start, end, weight));
				adjList[end].add(new Edge(end, start, weight));
			}

			// 정점 방문 여부
			boolean[] isVisited = new boolean[V + 1];

			// 우선 순위 큐
			PriorityQueue<Edge> que = new PriorityQueue<>();

			// 0번 정점부터 출발
			isVisited[0] = true;
			que.addAll(adjList[0]);

			// 확보한 정점 개수
			int count = 1;
			// 최소 비용
			int minVal = 0;

			while (count != V + 1) {
				// 간선 하나 꺼내서
				Edge edge = que.poll();

				// 연결된 정점이 이미 방문한 정점이면 건너뛰기
				if (isVisited[edge.end])
					continue;

				// 아직 방문 전이면
				// 해당 정점과의 가중치가 최소이므로 값을 더한다.
				minVal += edge.weight;

				// 가중치를 더한 정점을 기준으로 새로운 연결 정점들을 탐색한다.
				que.addAll(adjList[edge.end]);
				// 새로운 기준이 될 정점 탐색 여부 표시
				isVisited[edge.end] = true;

				// 탐색 완료 정점 개수 추가
				count++;
			}

			// 결과 문자열 생성
			sb.append("#").append(test).append(" ").append(minVal).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

}
