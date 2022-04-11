package exercise;

import java.util.Scanner;

public class Graph3 {

	static class Edge {
		int start;
		int end;

		public Edge(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + "]";
		}

	}

	// 간선 배열
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 정점의 수
		int V = scan.nextInt();
		// 간선의 수
		int E = scan.nextInt();

		// 간선 배열 생성
		Edge[] edges = new Edge[E];

		// 간선 정보 입력
		for (int i = 0; i < E; i++) {
			int start = scan.nextInt();
			int end = scan.nextInt();

			edges[i] = new Edge(start, end);

			// 출력
			System.out.println(edges[i]);

		}

		scan.close();

	}

}
