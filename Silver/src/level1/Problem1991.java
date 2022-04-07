package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1991 {

	// 노드 클래스
	private static class Node {
		// 노드명
		char data;
		// 자식 노드
		Node left, right;

		// 노드 생성자
		public Node(char data) {
			this.data = data;
		}

		public String toString() {
			return data + "";
		}
	}

	// 노드 개수
	private static int N;

	// Main
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 노드 개수 입력
		N = Integer.parseInt(br.readLine());

		// 노드들을 담을 배열 생성
		Node[] nodeArr = new Node[N];

		// 노드 이름
		char name = 'A';

		// 노드를 배열에 입력하는 반복문
		for (int i = 0; i < N; i++) {
			// 노드를 배열에 넣기
			nodeArr[i] = new Node(name++);
		}

		// 자식 정보를 입력하는 반복문
		for (int i = 0; i < N; i++) {
			// 한 줄을 읽어온 후
			StringTokenizer st = new StringTokenizer(br.readLine());

			int idx = st.nextToken().charAt(0) - 'A';
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			// 자식 정보를 입력
			nodeArr[idx].left = left == '.' ? null : nodeArr[left - 'A'];
			nodeArr[idx].right = right == '.' ? null : nodeArr[right - 'A'];
		}

		// 전위 순회
		System.out.println(preorder(nodeArr[0]));
		// 중위 순회
		System.out.println(inorder(nodeArr[0]));
		// 후위 순회
		System.out.println(postorder(nodeArr[0]));

	}

	// 전위 순회
	private static String preorder(Node node) {
		// 반환할 문자열
		String result = "";

		// 전위순회이므로 현재 노드 데이터부터 연결
		result += node.data;

		// 왼쪽 자식 노드가 있으면 연결
		if (node.left != null) {
			result += preorder(node.left);
		}

		// 오른쪽 자식 노드가 있으면 연결
		if (node.right != null) {
			result += preorder(node.right);
		}
		return result;
	}

	// 중위 순회
	private static String inorder(Node node) {
		// 반환할 문자열
		String result = "";

		// 왼쪽 노드가 있으면 먼저 연결
		if (node.left != null) {
			result += inorder(node.left);
		}

		// 현재 노드 연결
		result += node.data;

		// 오른쪽 노드 연결
		if (node.right != null) {
			result += inorder(node.right);
		}

		return result;
	}

	// 후위 순회
	private static String postorder(Node node) {
		// 반환할 문자열
		String result = "";

		// 왼쪽 자식이 있으면 먼저 연결
		if (node.left != null) {
			result += postorder(node.left);
		}

		// 오른쪽 자식이 있으면 이어서 연결
		if (node.right != null) {
			result += postorder(node.right);
		}

		// 마지막에 현재 노드 연결
		result += node.data;

		return result;
	}

}
