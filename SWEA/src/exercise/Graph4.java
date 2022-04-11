package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Graph4 {

	// 상호 배타 배열
	static int[] p;

	// KRUSKAL
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		// 정점의 개수
		int V = Integer.parseInt(st.nextToken());
		// 간선의 개수
		int E = Integer.parseInt(st.nextToken());

		// 간선 배열 생성
		// 0번 인덱스 : 시작 정점
		// 1번 인덱스 : 도착 정점
		// 2번 인덱스 : 가중치
		int[][] edges = new int[E][3];

		// 간선 정보 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		}

		// 가중치 기준 오름차순으로 정렬
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		// 상호 배타 배열 크기 입력
		p = new int[V];

		// 새로운 집합 생성
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}

		// 최소 비용
		int minVal = 0;
		// 선택한 간선의 수
		int count = 0;

		// MST
		for (int i = 0; i < E; i++) {
			int px = findSet(edges[i][0]);
			int py = findSet(edges[i][1]);

			// 다른 그룹이면 연결하고
			// 해당 간선 선택
			if (px != py) {
				union(px, py);
				minVal += edges[i][2];
				count++;
			}

			// 원하는 간선의 개수를 선택하였으면 반복 종료
			if (count == V - 1) {
				break;
			}
		}

		// 최단 비용 출력
		System.out.println(minVal);

	}

	// 새로운 집합 생성
	static void makeSet(int x) {
		p[x] = x;
	}

	// 집합 탐색
	static int findSet(int x) {

		if (x != p[x])
			p[x] = findSet(p[x]);

		return p[x];
	}

	// 합집합
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

}
