package level2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 노드 클래스 생성
class Node11725 {
	// 노드 번호
	int data;
	// 부모 노드 정보
	int parent;
	// 연결된 노드 정보
	ArrayList<Integer> connect;

	Node11725(int data) {
		this.data = data;
		this.parent = 0;
		this.connect = new ArrayList<>();
	}
}

public class Problem11725 {

	// 노드들을 저장할 배열
	static Node11725[] nodeList;
	// 탐색 여부를 저장할 배열
	static boolean[] isVisited;
	// 노드 개수
	static int N;

	// 11725. 트리의 부모 찾기
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 노드 개수 입력
		N = Integer.parseInt(br.readLine());

		// 노드 저장 배열 크기 입력
		nodeList = new Node11725[N + 1];
		isVisited = new boolean[N + 1];

		// 노드의 번호를 입력한 후 배열에 저장
		for (int i = 1; i <= N; i++) {
			nodeList[i] = new Node11725(i);
		}

		// 노드별 연결 정보를 노드 객체 안에 반영
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			nodeList[node1].connect.add(node2);
			nodeList[node2].connect.add(node1);
		}

		// 1번 노드에서 출발하여 부모 정보 탐색
		bfs(1);

		// 2번 노드부터 부모 노드 출력
		for (int i = 2; i <= N; i++) {
			System.out.println(nodeList[i].parent);
		}
	}

	private static void bfs(int start) {

		// 큐 생성
		Queue<Node11725> bfsQue = new LinkedList<>();

		// 출발 노드 추가
		bfsQue.add(nodeList[start]);

		// 출발 노드 탐색 여부 표시
		isVisited[start] = true;

		while (!bfsQue.isEmpty()) {
			Node11725 now = bfsQue.poll();

			// 현재 노드 기준
			// 해당 노드에 포함된 연결 노드 중 탐색 전 노드는 모두 해당 노드의 자식
			for (int i = 0; i < now.connect.size(); i++) {
				// 연결 리스트 중 하나의 노드를 꺼냄
				Node11725 connectedNode = nodeList[now.connect.get(i)];

				if (isVisited[connectedNode.data] == false) {
					// 자식 노드면 부모 정보를 입력하고
					connectedNode.parent = now.data;
					// 탐색할 노드로 큐에 추가
					bfsQue.add(connectedNode);
					// 탐색 여부 표시
					isVisited[connectedNode.data] = true;
				}
			}
		}

	}

}
