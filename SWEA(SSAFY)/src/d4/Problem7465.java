package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem7465 {

	// 상호 배타 배열
	static int[] p;
	// 랭크 배열
	static int[] rank;

	// 7465. 창용 마을 무리의 개수
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 개수 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 사람 수
			int people = Integer.parseInt(st.nextToken());
			// 관계 수
			int relation = Integer.parseInt(st.nextToken());

			// 상호배타 배열
			p = new int[people + 1];
			// 랭크 배열
			rank = new int[people + 1];

			// 새로운 집합 생성
			for (int i = 1; i <= people; i++) {
				makeSet(i);
			}

			// 무리 만드는 반복문
			for (int i = 0; i < relation; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				union(x, y);
			}

			// 대표자 최신화
			for (int i = 1; i <= people; i++) {
				findSet(i);
			}

			// 각 무리의 대표자를 Set에 추가
			HashSet<Integer> leader = new HashSet<>();
			for (int i = 1; i <= people; i++) {
				leader.add(p[i]);
			}

			// 중복을 제거하였으므로 Set의 크기가 곧 무리의 개수
			sb.append("#").append(test).append(" ").append(leader.size()).append('\n');
		}

		// 결과 출력
		System.out.println(sb);
	}

	// 합집합
	private static void union(int x, int y) {
		link(findSet(x), findSet(y));
	}

	// 집합 연결
	private static void link(int x, int y) {
		if (rank[x] > rank[y]) {
			p[y] = x;
		} else {
			p[x] = y;
			if (rank[x] == rank[y]) {
				rank[y]++;
			}
		}
	}

	// 집합 탐색 메서드
	private static int findSet(int person) {
		// person이 루트가 아닌 경우
		if (person != p[person])
			p[person] = findSet(p[person]);

		return p[person];
	}

	// 새로운 집합 생성 메서드
	private static void makeSet(int person) {
		p[person] = person;
		rank[person] = 0;

	}

}
