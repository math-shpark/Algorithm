package d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1248 {

	// 거쳐온 조상들을 추가하는 리스트
	static List<Integer> parentList;
	// 연결 정보를 저장하는 배열
	static int[][] space;
	// 공통 조상
	static int commonParent;
	// 서브 트리의 노드 개수
	static int size;

	// 1248. 공통 조상
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 테스트 케이스 크기 입력
		int testCase = Integer.parseInt(br.readLine());

		for (int test = 1; test <= testCase; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 노드 수
			int nodeCount = Integer.parseInt(st.nextToken());
			// 간선 수
			int edgeCount = Integer.parseInt(st.nextToken());
			// 자식 1
			int findNode1 = Integer.parseInt(st.nextToken());
			// 자식 2
			int findNode2 = Integer.parseInt(st.nextToken());

			// 배열 크기 지정
			// 노드 번호를 인덱스로 취할 목적으로 1 더 큰 크기로 지정
			// 0번 인덱스 : 부모
			// 1, 2번 인덱스 : 자식 2명
			space = new int[nodeCount + 1][3];
			// 리스트 초기화
			parentList = new ArrayList<>();

			// 공통 조상 초기화
			commonParent = 0;
			// 서브 트리 크기 초기화
			size = 1;

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < edgeCount; i++) {
				// 부모 노드
				int parent = Integer.parseInt(st.nextToken());
				// 자식 노드
				int child = Integer.parseInt(st.nextToken());

				// 부모 정보 입력
				space[child][0] = parent;

				// 남는 칸에 자식 정보 입력
				if (space[parent][1] == 0) {
					space[parent][1] = child;
				} else {
					space[parent][2] = child;
				}
			}

			// 공통 조상을 찾는 메소드
			search(findNode1, findNode2);
			// 서브 트리 크기 계산하는 메소드
			nodeCount(commonParent);

			// 결과 문자열
			sb.append("#").append(test).append(" ").append(commonParent).append(" ").append(size).append('\n');
		}

		System.out.println(sb);

	}

	// 서브 트리 크기 계산
	private static void nodeCount(int startNode) {

		// 자식이 있으면
		if (space[startNode][1] != 0) {
			// 크기에 반영한 후
			size++;
			// 재귀
			nodeCount(space[startNode][1]);
		}

		// 자식이 있으면
		if (space[startNode][2] != 0) {
			// 크기에 반영한 후
			size++;
			// 재귀
			nodeCount(space[startNode][2]);
		}

	}

	// 공통 조상을 찾는 메소드
	private static void search(int findNode1, int findNode2) {
		// 현재 노드 기준 부모 노드들
		int parent1 = space[findNode1][0];
		int parent2 = space[findNode2][0];

		// 현재 부모1이 이미 다른 자식에 의해 추가된 경우
		// 먼저 1에 도달하면 더이상 부모가 없으므로
		// parent1 != 0 조건이 없으면 공통 조상이 0이 될 수 있음
		if (parent1 != 0 && parentList.contains(parent1)) {
			// 결과 반환
			commonParent = parent1;
			return;
		} else if (parent2 != 0 && parentList.contains(parent2)) {
			// 현재 부모 2가 이미 다른 자식에 의해 추가된 경우
			// 결과 반환
			commonParent = parent2;
			return;
		} else if (parent1 == parent2) {
			// 우연히 동시에 찾으면
			// 해당 결과 반환
			commonParent = parent1;
			return;
		}

		// 위의 경우에 모두 해당하지 않으면
		// 일단 리스트에 추가
		parentList.add(parent1);
		parentList.add(parent2);

		// 기준 노드를 부모로 변경하여 재귀 실행
		search(parent1, parent2);

	}

}
