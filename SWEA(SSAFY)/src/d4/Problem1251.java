package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem1251 {

	// 상호 배타 배열
	static int[] p;
	// 랭크 배열
	static int[] rank;

	// 1251. 하나로 (KRUSKAL)
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			// 섬 개수
			int islandNum = Integer.parseInt(br.readLine());
			// 간선 수
			int E = (islandNum * (islandNum - 1)) / 2;

			// 간선 배열
			double[][] edges = new double[E][3]; // 0 : 시작점, 1 : 도착점, 2 : 가중치

			// 섬들의 x좌표 저장 배열
			int[] xArr = new int[islandNum];
			// 섬들의 y좌표 저장 배열
			int[] yArr = new int[islandNum];

			// 섬 좌표 입력
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < islandNum; i++) {
				xArr[i] = Integer.parseInt(st1.nextToken());
				yArr[i] = Integer.parseInt(st2.nextToken());
			}
			
			// 시작 정점
			int start = 0;
			// 도착 정점
			int end = 1;
			// 완전 그래프 만들기
			for (int edge = 0; edge < E; edge++) {
				edges[edge][0] = start;
				edges[edge][1] = end;
				edges[edge][2] = Math.pow(Math.abs(xArr[start] - xArr[end]), 2)
						+ Math.pow(Math.abs(yArr[start] - yArr[end]), 2);

				end++;

				if (end == islandNum) {
					start++;
					end = start + 1;
				}
			}

			// 섬들 간의 거리를 기준으로 오름차순 정렬
			Arrays.sort(edges, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return (int) (o1[2] - o2[2]);
				}
			});

			// 배열 크기 입력
			p = new int[islandNum];
			rank = new int[islandNum];

			// 각 섬들을 원소로 집합 생성
			for (int i = 0; i < islandNum; i++) {
				makeSet(i);
			}

			// 환경 부담금
			double tax = Double.parseDouble(br.readLine());

			// 최소 비용
			double minVal = 0;
			// 선택한 다리 수
			int count = 0;

			// MST
			for (int i = 0; i < E; i++) {
				int i1 = findSet((int) edges[i][0]);
				int i2 = findSet((int) edges[i][1]);

				// 연결되지 않은 선이면 다리 건설
				if (i1 != i2) {
					union(i1, i2);
					minVal += edges[i][2];
					count++;
				}

				// 필요한 다리를 모두 건설했으면 반복 종료
				if (count == islandNum - 1)
					break;
			} // MST 종료

			// 결과 문자열 생성
			sb.append("#").append(test).append(" ").append(Math.round(minVal * tax)).append('\n');
		}

		// 결과 출력
		System.out.println(sb);

	}

	// 새로운 집합 생성
	private static void makeSet(int island) {
		p[island] = island;
		rank[island] = 0;
	}

	// 그룹 대표 찾는 메서드
	private static int findSet(int island) {
		if (island == p[island])
			return island;

		return p[island] = findSet(p[island]);
	}

	// 합집합
	private static void union(int island1, int island2) {
		link(findSet(island1), findSet(island2));
	}

	// 두 집합 연결
	private static void link(int island1, int island2) {
		if (rank[island1] > rank[island2])
			p[island2] = p[island1];
		else {
			p[island1] = p[island2];
			if (rank[island1] == rank[island2])
				rank[island2]++;
		}
	}

}
