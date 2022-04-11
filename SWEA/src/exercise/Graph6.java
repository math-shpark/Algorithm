package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Graph6 {

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int value;

		public Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}

		// 오름차순 정렬
		@Override
		public int compareTo(Edge o) {
			return this.value - o.value;
		}
	}

	// PRIM 2(우선순위 큐)
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 매개 변수 입력
		st = new StringTokenizer(br.readLine());
		// 정점의 개수
		int V = Integer.parseInt(st.nextToken());
		// 간선의 개수
		int E = Integer.parseInt(st.nextToken());

		// 인접 리스트
		List<Edge>[] adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 간선 연결 정보 및 가중치 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[start].add(new Edge(start, end, weight));
			adjList[end].add(new Edge(end, start, weight));
		}

		// 정점 방문 여부
		boolean[] isVisited = new boolean[V];

		// 우선 순위 큐
		PriorityQueue<Edge> que = new PriorityQueue<>();

		// 0번부터 출발
		isVisited[0] = true;

		// 출발 정점과 연결된 간선 모두 입력
		que.addAll(adjList[0]);

		// 확보한 정점 개수
		// 출발 정점은 이미 탐색했으므로 1로 시작
		int count = 1;
		// 총 비용
		int total = 0;

		while (count != V) {
			// 간선 하나 꺼내서
			Edge edge = que.poll();

			// 연결된 정점이 이미 방문한 정점은 건너뛰기
			if (isVisited[edge.end])
				continue;

			// 아니면
			// 해당 정점과의 거리 값 더하기
			total += edge.value;

			// 연결된 정점 기준 연결된 정점을 큐에 추가하기
			que.addAll(adjList[edge.end]);
			// 다음 기준 정점 탐색 여부 표시
			isVisited[edge.end] = true;
			// 탐색 완료 정점 개수 추가
			count++;
		}

		// 결과 출력
		System.out.println(total);

	}

}
