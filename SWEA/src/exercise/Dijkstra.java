package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Dijkstra {

	// 정점 클래스 생성
	static class Node {
		int v, weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
	}

	// 매개변수(정점, 간선 수)
	static int V, E;
	// 상수 지정(초기 최대값)
	static final int INF = Integer.MAX_VALUE;
	// 인접 리스트
	static List<Node>[] adjList;
	// 최소 거리 배열
	static int[] dist;

	// Dijkstra
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 매개변수 입력(정점 번호는 0번부터)
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// 인접 리스트 객체 생성
		adjList = new ArrayList[V];

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 최소 거리 배열 크기 입력
		dist = new int[V];
		Arrays.fill(dist, INF);

		// 간선 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			adjList[start].add(new Node(end, distance));
		}

		// 다익스트라 알고리즘 실행
		dijkstra(0);

		// 결과 출력
		System.out.println(Arrays.toString(dist));
	}

	private static void dijkstra(int start) {

		// 방문 여부 배열
		boolean[] isVisited = new boolean[V];

		// 시작 노드는 거리 0
		dist[start] = 0;

		// 마지막으로 남은 정점은 자동으로 간선이 선택되므로
		// 반복횟수는 V-1로 하여 반복한다.
		for (int i = 0; i < V - 1; i++) {
			// 방문하지 않은 정점 중 거리가 최소 정점의 인덱스
			int minIdx = -1;
			// 최소 거리를 저장할 변수
			int minValue = INF;

			// 0번 정점부터 마지막 정점까지 확인하며
			// 새로운 출발 정점을 찾는다.
			for (int j = 0; j < V; j++) {
				// 이미 탐색한 정점은 출발 정점이 될 수 없다.
				if (isVisited[j])
					continue;
				// 아직 탐색하지 않은 정점 중 거리값이 제일 작은 정점을 찾는다.
				if (minValue > dist[j]) {
					minValue = dist[j];
					minIdx = j;
				}
			} // 새로운 출발 정점 탐색 완료

			// 새로운 출발 정점 탐색 여부 표시
			isVisited[minIdx] = true;

			for (int j = 0; j < adjList[minIdx].size(); j++) {
				// 새로운 출발 정점과 연결된 정점을 하나씩 확인하면서
				Node current = adjList[minIdx].get(j);

				// 연결된 정점이 이미 탐색된 경우는 건너뛰고
				if (isVisited[current.v])
					continue;

				// 탐색 전인데 이미 입력된 거리 값보다
				// 새로운 출발 정점을 기준으로 거리를 누적한 값이 더 작으면 갱신
				if (dist[current.v] > dist[minIdx] + current.weight)
					dist[current.v] = dist[minIdx] + current.weight;
			}
		}

	}

}
