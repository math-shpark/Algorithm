package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5639 {

	static class Node {
		int nodeNum;
		Node left, right;

		Node(int nodeNum) {
			this.nodeNum = nodeNum;
		}

		Node(int nodeNum, Node left, Node right) {
			this.nodeNum = nodeNum;
			this.left = left;
			this.right = right;
		}

		// 자식 노드 추가 메서드
		void insert(int num) {
			if (num < this.nodeNum) {
				if (this.left == null)
					this.left = new Node(num);
				else
					this.left.insert(num);
			} else {
				if (this.right == null)
					this.right = new Node(num);
				else
					this.right.insert(num);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Node root = new Node(Integer.parseInt(br.readLine()));

		while (true) {
			String input = br.readLine();
			if (input == null || input.equals(""))
				break;
			root.insert(Integer.parseInt(input));
		}

		// 후위 순회
		postOrder(root);
	}

	static void postOrder(Node node) {

		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.nodeNum);
	}

}
