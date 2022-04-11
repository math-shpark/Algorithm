package exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Graph5 {

	// PRIM
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 매개 변수 입력
		st = new StringTokenizer(br.readLine());
		// 정점의 개수
		int V = Integer.parseInt(st.nextToken());
		// 간선의 개수
		int E = Integer.parseInt(st.nextToken());

		// 간선의 정보 저장
		int[][] adjArr = new int[V][V];

		// 간선 연결 정보 및 가중치 입력
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjArr[start][end] = adjArr[end][start] = weight;
		}

		// 정점 방문 여부
		boolean[] isVisited = new boolean[V];

		// 부모
		int[] pi = new int[V];
		// 부모로부터 거리 저장
		int[] distance = new int[V];

		// 거리 배열을 임의의 아주 큰 값으로 채우기
		Arrays.fill(distance, Integer.MAX_VALUE);

		// 0번 정점부터 시작
		pi[0] = -1;
		distance[0] = 0;

		// 매개 변수
		// 최솟값, 최솟값 인덱스, 비용 총합
		int min, idx, total = 0;

		// 마지막으로 남는 정점을 기준으로 갱신하는 값은 없으므로
		// V-1번 반복한다.(V번 해도 결과는 동일하나 얻는 이득은 없음)
		for (int i = 0; i < V - 1; i++) {
			// 초기화
			min = Integer.MAX_VALUE;
			idx = -1;

			// 아직 방문하지 않은 정점 중
			// 가장 가까운 정점 선택
			for (int j = 0; j < V; j++) {
				if (!isVisited[j] && distance[j] < min) {
					min = distance[j];
					idx = j;
				}
			}

			// 가장 가까운 정점 방문 여부 표시
			isVisited[idx] = true;
			// 갱신
			for (int j = 0; j < V; j++) {
				// idx 정점을 기준으로
				// 해당 정점과 연결되어 있으면서
				// 아직 방문하지 않은 정점이면서
				// idx 정점을 기준으로 해당 정점과의 거리가 더 짧은 경우
				if (!isVisited[j] && adjArr[idx][j] != 0 && distance[j] > adjArr[idx][j]) {
					// 해당 정점의 부모를 다음 방문하는 정점으로 하고
					pi[j] = idx;
					// 거리 값을 갱신한다.
					distance[j] = adjArr[idx][j];
				}
			}
		}

		// 결과 값 계산
		for (int i = 0; i < V; i++) {
			total += distance[i];
		}

		// 결과 출력
		System.out.println(total);

	}

}
