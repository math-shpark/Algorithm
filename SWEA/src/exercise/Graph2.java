package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph2 {

	// 인접 리스트
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 정점의 수
		int V = scan.nextInt();
		// 간선의 수
		int E = scan.nextInt();

		// 인접 리스트 배열 생성
		List<Integer>[] adjList = new ArrayList[V + 1];

		// 배열 안에 리스트 객체 주입
		for (int i = 0; i < V + 1; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		// 간선 정보 입력
		for (int i = 0; i < E; i++) {
			int start = scan.nextInt();
			int end = scan.nextInt();

			adjList[start].add(end);
			// 무향 그래프일 경우 추가
//			adjList[end].add(start);
		}

		// 출력
		for (int i = 0; i < V; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < adjList[i].size(); j++) {
				System.out.print(adjList[i].get(j) + " ");
			}
			System.out.println();
		}

		scan.close();

	}

}
