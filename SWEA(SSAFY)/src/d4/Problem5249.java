package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem5249 {

	// 상호 배타 배열
	static int[] p;
	// 랭크 배열
	static int[] rank;

	// 5249. 최소 신장 트리 (KRUSKAL)
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

			// 간선 배열
			int[][] edges = new int[E][3]; // 0 : 시작점, 1 : 도착점, 2 : 가중치

			// 간선 정보 입력
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				// 0번 인덱스 시작점 입력
				edges[i][0] = Integer.parseInt(st.nextToken());
				// 1번 인덱스 도착점 입력
				edges[i][1] = Integer.parseInt(st.nextToken());
				// 2번 인덱스 가중치 입력
				edges[i][2] = Integer.parseInt(st.nextToken());
			}

			// KRUSKAL 알고리즘을 적용하기 위해 가중치를 기준으로 오름차순으로 정렬한다.
			// 가중치를 기준으로 정렬하므로 제네릭 타입을 1차원 배열로 Comparator을 생성한다.
			Arrays.sort(edges, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// 가중치 기준 오름차순 정렬
					return o1[2] - o2[2];
				}
			});

			// 상호 배타 배열 크기 입력
			// 마지막 정점 번호가 입력되므로 크기는 그보다 1 큰 크기로 설정해야 한다.
			p = new int[V + 1];
			rank = new int[V + 1];

			// 집합 생성
			for (int i = 0; i <= V; i++) {
				makeSet(i);
			}

			// 최소 비용
			int minVal = 0;
			// 선택한 간선 수
			int count = 0;

			// MST
			for (int i = 0; i < E; i++) {
				int px = findSet(edges[i][0]);
				int py = findSet(edges[i][1]);

				// 다른 그룹이면 간선을 선택하고 두 그룹 연결
				if (px != py) {
					union(px, py);
					minVal += edges[i][2];
					count++;
				}

				// 지금까지 선택한 간선이 원하는 만큼 선택되면 반복 종료
				if (count == V) {
					break;
				}
			} // MST 종료

			// 결과 문자열 생성
			sb.append("#").append(test).append(" ").append(minVal).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

	// 집합 생성
	private static void makeSet(int num) {
		p[num] = num;
		rank[num] = 0;
	}

	// 대표자 탐색
	private static int findSet(int num) {
		// 단일 집합인 경우
		if (num == p[num])
			return num;

		// 대표자 반환
		return p[num] = findSet(p[num]);
	}

	// 합집합
	private static void union(int num1, int num2) {
		link(findSet(num1), findSet(num2));
	}

	// 집합 연결
	private static void link(int num1, int num2) {
		if (rank[num1] > rank[num2])
			p[num2] = p[num1];
		else {
			p[num1] = p[num2];
			if (rank[num1] == rank[num2]) {
				rank[num2]++;
			}
		}
	}

}
