package level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1916 {

	static class City implements Comparable<City> {
		int endNode, price;

		public City(int end, int price) {
			this.endNode = end;
			this.price = price;
		}

		@Override
		// 오름차순 정렬
		public int compareTo(City o) {
			return price - o.price;
		}
	}

	// 매개변수
	// 도시 수
	static int cities;
	// 버스 수
	static int buses;
	// 출발 도시 번호
	static int startCity;
	// 도시 연결 정보 저장 배열
	static List<City>[] cityList;
	// 비용 저장 배열
	static int[] priceArr;

	// 1916. 최소비용 구하기
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 매개변수 입력
		cities = Integer.parseInt(br.readLine());
		buses = Integer.parseInt(br.readLine());

		// 배열 크기 입력
		cityList = new ArrayList[cities + 1];
		priceArr = new int[cities + 1];

		Arrays.fill(priceArr, Integer.MAX_VALUE);

		// 각 인덱스에 맞춰 도시 연결 객체 생성
		for (int i = 1; i <= cities; i++) {
			cityList[i] = new ArrayList<>();
		}

		// 연결 정보 입력
		StringTokenizer st;
		for (int i = 0; i < buses; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());

			cityList[start].add(new City(end, price));

		}

		// 출발 도시 및 도착 도시 입력
		st = new StringTokenizer(br.readLine());
		startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());

		// 다익스트라 알고리즘
		bfs(startCity);

		System.out.println(priceArr[endCity]);

	}

	private static void bfs(int start) {
		// 우선순위 큐
		PriorityQueue<City> que = new PriorityQueue<>();

		// 탐색 여부 배열
		boolean[] isVisited = new boolean[cities + 1];

		// 출발 노드 추가
		que.add(new City(start, 0));

		priceArr[start] = 0;

		while (!que.isEmpty()) {
			City now = que.poll();
			int nextCity = now.endNode;

			if (isVisited[nextCity])
				continue;

			isVisited[nextCity] = true;

			for (City city : cityList[nextCity]) {
				if (priceArr[city.endNode] > priceArr[nextCity] + city.price) {
					priceArr[city.endNode] = priceArr[nextCity] + city.price;

					que.add(new City(city.endNode, priceArr[city.endNode]));
				}
			}

		}

	}

}
