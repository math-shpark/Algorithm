package d3;

import java.util.Scanner;

public class Problem2930_2 {
	static int[] nodeArr;
	static StringBuilder sb = new StringBuilder();
	static int addIdx;

	// 2930. 힙(배열 버전)
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 테스트 케이스 개수 입력
		int testCase = scan.nextInt();

		for (int test = 1; test <= testCase; test++) {
			// 연산 개수 입력
			int N = scan.nextInt();

			// 노드를 모두 수용할 수 있는 크기의 배열 생성
			nodeArr = new int[100001];
			// 노드를 추가할 인덱스 위치
			addIdx = 1;
			// 출력 양식
			sb.append("#").append(test).append(" ");

			for (int i = 0; i < N; i++) {
				// 명령 입력
				int command = scan.nextInt();

				// 입력한 명령에 맞춰 메소드 호출
				switch (command) {
				case 1:
					addNode(scan.nextInt());
					break;
				case 2:
					deleteNode();
					break;
				}

			}

			sb.append('\n');

		}

		System.out.println(sb);

		scan.close();

	}

	// 추가
	private static void addNode(int nextNode) {

		// 추가할 위치에 우선 추가한 후
		nodeArr[addIdx] = nextNode;

		// 방금 추가한 위치가 루트면 건너뛰기
		if (addIdx == 1) {
			addIdx++;
			return;
		}

		// 지금 추가한 노드의 위치를 저장할 변수
		int idx = addIdx;

		while (true) {
			// 부모 인덱스
			int parent = idx / 2;
			// 현재 추가한 값이 부모보다 크면
			if (nodeArr[idx] > nodeArr[parent]) {
				// swap을 실행하고
				int temp = nodeArr[parent];
				nodeArr[parent] = nodeArr[idx];
				nodeArr[idx] = temp;

				// 현재 추가한 값의 위치를 부모 위치로 변경
				idx = parent;

				// 이동할 위치가 루트면 반복문 종료
				if (idx == 1) {
					break;
				}
			} else {
				// 부모가 더 크거나 같으면 반복문 종료
				break;
			}
		}
		// 추가할 위치 이동
		addIdx++;
	}

	// 삭제
	private static void deleteNode() {

		// 추가할 위치가 루트면
		// 트리에 추가된 노드가 없는 것이므로
		// -1을 출력
		if (addIdx <= 1) {
			sb.append(-1).append(" ");
			return;
		}

		// 트리에 노드가 있으면 1번 노드 출력
		sb.append(nodeArr[1]).append(" ");

		// 1개의 노드가 삭제되었으므로
		// 추가할 위치를 1 감소
		addIdx--;

		// 마지막에 추가한 노드를 루트 노드로 일단 이동하고
		nodeArr[1] = nodeArr[addIdx];
		// 추가할 위치를 다시 비우기
		nodeArr[addIdx] = 0;

		// 방금 루트 노드로 이동한 노드의 위치를 저장할 변수
		int idx = 1;

		while (true) {

			// 자식 인덱스가 범위 밖이면
			// 현재 위치가 제일 마지막 레벨이므로 반복문 종료
			if (idx * 2 + 1 > 100000) {
				break;
			}

			// 자식 인덱스가 범위 내면
			// 좌, 우 자식 값을 변수에 저장
			int child1 = nodeArr[idx * 2];
			int child2 = nodeArr[idx * 2 + 1];

			// 현재 노드가 자식보다 크거나 같으면 반복문 종료
			if (nodeArr[idx] >= Math.max(child1, child2)) {
				break;
			}

			// 아니면 swap 진행
			int temp = nodeArr[idx];

			// swap은 자식 중 더 큰 자식과 진행
			if (child1 >= child2) {
				nodeArr[idx] = child1;
				nodeArr[idx * 2] = temp;
				idx *= 2;
			} else {
				nodeArr[idx] = child2;
				nodeArr[idx * 2 + 1] = temp;
				idx = 2 * idx + 1;
			}

		}

	}

}
